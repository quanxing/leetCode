package LeetCodeOJ;

import java.util.Queue;
import java.util.Stack;

/* 81.Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?
 */
public class SearchRotateArray2 {

    /*
     * ��ͬ�ķ�����leetcode��վ�ύ�Ľ��
     */
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            // ����ļ����д����Դ������ط���˼�롣
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[low] < nums[mid]) {
                // �������
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {
                // ��������ұ�����
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // low == mid 可能是出现多个元素
            else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n = { 4, 5, 6, 7, 7, 8, 0, 1, 1, 2, 3 };
        // int [] n ={1,0,1,1,1,1,1};
        System.out.println(new SearchRotateArray2().search(n, 1));

    }

}
