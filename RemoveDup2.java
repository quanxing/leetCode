package LeetCodeOJ;

/*
 * Follow up for ��Remove Duplicates��: 
 * What if duplicates are allowed at most twice?
 For example, Given sorted array A = [1,1,1,2,2,3],
 Your function should return length = 5, and A is now [1,1,2,2,3]
 */
public class RemoveDup2 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            /*
             * if(nums[i] == nums[index] && count < 2){ nums[++index] = nums[i];
             * count++; }else if(nums[i] == nums[index] && count == 2){ }else{
             * nums[++index] = nums[i]; count = 1; }
             */
            /*
             * ������Ż���Ĵ��룺��������˼˵������Ż���������Ӧ���Ǽ������ҽ� 不知道为何乱码׳
             */
            // 这个count可以控制排序数组中单个数字能重复多少次
            if (nums[i] == nums[index]) {
                if (count < 2) {
                    nums[++index] = nums[i];
                    count++;
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return index + 1;

    }

    public static void main(String[] args) {
        int[] n = { 1, 1, 1, 1, 2, 2 };
        System.out.println(new RemoveDup2().removeDuplicates(n));
    }
}
