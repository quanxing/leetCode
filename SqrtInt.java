package LeetCodeOJ;

/**
 * huaw6.java 有详细的题目
 * 
 * @author fqx
 *
 */
public class SqrtInt {

    public static int sqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int begin = 1;
        int end = x;
        int middle = (begin + end) / 2;
        while (begin <= end) {

            // 不要写成middle*middle==x，会溢出
            if (middle == x / middle) {
                return middle;
            } else {
                if (middle < x / middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            middle = (begin + end) / 2;
        }
        // 结束条件end一定<begin，所以返回 end
        return end;
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x / mid >= mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            } else if (x / mid < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 牛顿法求解 求平方根
     * 
     * @param data
     * @return
     * @return
     */
    private static double my_sqrt(double data) {// 牛顿迭代算法
        double x = 1;
        while (Math.abs(1.0 / 2.0 * (x + data / x) - x) >= 0.0001) {
            x = 1.0 / 2.0 * (x + data / x);
        }
        return x;
    }

    public static void main(String[] args) {
        System.err.println(sqrt(7));
        System.out.println(mySqrt(5));
    }
}
