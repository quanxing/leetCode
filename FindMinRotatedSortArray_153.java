package LeetCodeOJ;

/*
 * leetCode
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand.
 * Find the minimum element.
 * 
 */
public class FindMinRotatedSortArray_153 {
    /**
     * 不重复数组
     * 
     * @param nums
     * @return 返回数组中最小值
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            // 因为不重复所以 第一步判断起码有一个元素，
            // 否则一定是判断< ,没有=

            if (nums[low] < nums[high]) {
                return nums[low];
            } else {
                // low > high :说明在某一点翻转了数组
                int mid = low + (high - low) / 2;
                /*
                 * 如果中间的比最右边的还大，那么最小的肯定在mid+1 - high 否则 肯定在low,mid nums[mid] >
                 * nums[high]; 因为不重复元素，所以绝对不可能等于最近的[low,high];mid = low;
                 * 但是当有重复的元素时，mid 可以等于high的
                 */
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                /*
                 * if(nums[low] <= nums[mid]){ low = mid + 1; }else{ high = mid;
                 * }
                 */
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 2 }; // {1,2},{3,4,2},{7,8,9,0,2,4,5}
        System.out.println(new FindMinRotatedSortArray_153().findMin(a));
    }
}
