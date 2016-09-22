package LeetCodeOJ;

/*
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 2015-04-25 end.
 */
public class MedianNum2 {
    public double findMedian(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m == 0 && n == 0)
            return -1;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        // ������ż���棺�����м���Ǹ�l==r��ż��l = r+1���ٳ���2��Ȼ��lλ�õ�ֵ
        return (getKth(a, 0, b, 0, l) + getKth(a, 0, b, 0, r)) / 2.0;
    }

    public double getKth(int[] a, int astart, int[] b, int bstart, int k) {
        // ����һ��Ϊ��ʱ����ֱ��ȥ��������ĵ�k��
        /*
         * ����ȴ�����о�͸������ĺ��塣��Ҫ����������еı߽�������ô���ǵģ���
         * ���֪������a������i��Ԫ�أ� ��ôb��Ҫ����k-i��Ԫ�� ���������ռ�����ˡ�
         */
        if (astart > a.length - 1)
            return b[bstart + k - 1];
        if (bstart > b.length - 1)
            return a[astart + k - 1];
        if (k == 1) {
            return Math.min(a[astart], b[bstart]);
        }

        int amid = Integer.MAX_VALUE;
        int bmid = Integer.MAX_VALUE;
        if (astart + k / 2 - 1 < a.length)
            amid = a[astart + k / 2 - 1];
        if (bstart + k / 2 - 1 < b.length)
            bmid = b[bstart + k / 2 - 1];
        if (amid < bmid) {
            return getKth(a, astart + k / 2, b, bstart, k - k / 2);
        } else {
            return getKth(a, astart, b, bstart + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = { 1, 2 };
        System.out.println(new MedianNum2().findMedian(a, b));
    }
}
