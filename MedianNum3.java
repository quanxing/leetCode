package LeetCodeOJ;

/*
 * leetcode �������������λ������ǵ�k����
 */
public class MedianNum3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 != 0) {
            return getKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
        } else {
            return (getKth(nums1, 0, m, nums2, 0, n, total / 2) + getKth(nums1,
                    0, m, nums2, 0, n, total / 2 + 1)) / 2.0;
        }

    }

    /*
     * �����������еĵ�k����
     */
    public double getKth(int[] a, int astart, int m, int[] b, int bstart,
            int n, int k) {
        if (m > n) {
            return getKth(b, bstart, n, a, astart, m, k);
        }
        if (m == 0) {
            return b[k - 1];
        }
        if (k == 1) {
            return Math.min(a[astart], b[bstart]);
        }

        int partA = Math.min(k / 2, m), partB = k - partA;
        // partA��СԪ�� ȷ���ڵ�K������ߣ�������Ҫ�ҵ�ʣ���k-partAԪ�أ�
        if (a[astart + partA - 1] == b[bstart + partB - 1])
            return a[astart + partA - 1];
        else if (a[astart + partA - 1] > b[bstart + partB - 1])
            return getKth(a, astart, m, b, bstart + partB, n - partB, k - partB);
        else
            return getKth(a, astart + partA, m - partA, b, bstart, n, k - partA);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2 };
        int[] b = { 3, 4 };
        System.out.println(new MedianNum3().findMedianSortedArrays(a, b));
    }
}
