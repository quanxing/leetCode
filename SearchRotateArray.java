package LeetCodeOJ;

/*
 * Search in Rotated Sorted Array
 * Ĭ����������
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 mighSearch in Rotated Sorted Arrayt become 4 5 6 7 0 1 2).
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 */
public class SearchRotateArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            /*
             * mid = (low + high)/2; if(target == nums[mid]){ return mid; }else
             * if(target < nums[mid]){ if((nums[mid] >= nums[low] && target <
             * nums[low])){ low = mid + 1; }else{ high = mid - 1; } }else{
             * if(nums[mid] <= nums[high] && target > nums[high]){ high = mid -
             * 1; }else{ low = mid + 1; } }
             */

            /*
             * mid = (low + high)/2; if(target == nums[mid]){ return mid; }else
             * if(target < nums[mid]){
             * 
             * 1��������������ҿ�������߲��ң�
             * 2�����������򣻴�ʱ�ұ߿϶����򣬵��Ƕ������target �����������ֻ������߲���
             * 
             * if((nums[mid] >= nums[low] && target >= nums[low])){ high = mid -
             * 1; }else if(nums[low] > nums[mid]){ high = mid - 1; }else{ low =
             * mid + 1; }
             * 
             * }else{
             * 
             * 1�������������ҿ������ұ߲��ң� 2������ұ����� �����������ֻ�����ұ߲���
             * 
             * if(nums[mid] <= nums[high] && target <= nums[high]){ low = mid +
             * 1; }else if(nums[mid] > nums[high]){ low = mid + 1; }else{ high =
             * mid - 1; } }
             */

            /*
             * ������
             */
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else {
                // 左边有序;无重复所以可以写等于，因为当走到一个元素low==mid
                if (nums[low] <= nums[mid]) {
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                // 右边有序
                else {
                    if (target > nums[mid] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n = { 4, 5, 6, 7, 8, 0, 1, 2, 3, 3 };
        System.out.println(new SearchRotateArray().search(n, 8));
    }
}
