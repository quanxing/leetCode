package LeetCodeOJ;

/* 26.Remove Duplicates from Sorted Array  from leetCode
 * [1,1,2]
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 */

//ʱ�临�Ӷ�o(n)
public class RemoveDup {
    public int func(int[] nums) {
        int tmp = nums[0];
        int len = nums.length;
        int count = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i++] == tmp) {
                len--;
            }
            if (--i < nums.length) {
                nums[++j] = nums[i];
                tmp = nums[i];
            }
        }
        return len;
    }

    /*
     * �������������Ȼ�ȵĵ�һ������Ҫ��ࣺʱ�临�Ӷ�o(n)
     */
    public int len(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                // 只保留与index不相等的元素，并且将++index的值为当前nums[i]
                // 很简洁
                nums[++index] = nums[i];
            }
        }
        // ��ӡ�������ʾ����ʱ������
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        return index + 1;
    }

    public static int fun() {
        int count = 0;
        int num1 = 12345;
        while (num1 != 0) {
            count++;
            num1 &= (num1 - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] n = { -999, -999, -998, -998, -997, -997, -996, -996, -995, -995,
                -994, -994 };
        // int len = new RemoveDup().func(n);
        int len = new RemoveDup().len(n);
        System.out.println(len);
    }
}
