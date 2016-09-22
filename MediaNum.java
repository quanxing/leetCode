package LeetCodeOJ;

/* 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MediaNum {
    /*
     * O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = 0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            len = (nums1.length + nums2.length) / 2;
        } else {
            len = (nums1.length + nums2.length) / 2 + 1;
        }

        int i = 0, j = 0, k = 0;
        int result = 0;
        while (i < nums1.length && j < nums2.length) {
            if (len == k) {
                return result;
            } else {
                if (nums1[i] < nums2[j]) {
                    result = nums1[i];
                    i++;
                } else {
                    result = nums2[j];
                    j++;
                }
                k++;
            }
        }
        while (i < nums1.length) {
            if (k == len) {
                break;
            } else {
                result = nums1[i];
                k++;
                i++;
            }
        }
        while (j < nums2.length) {
            if (k == len) {
                break;
            } else {
                result = nums2[j];
                k++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = { 1, 4, 6, 7, 9 };
        int[] n2 = { 2, 5, 8, 14, 15, 18 };
        System.out.println(new MediaNum().findMedianSortedArrays(n1, n2));
    }
}
