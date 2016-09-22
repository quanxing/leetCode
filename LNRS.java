package LeetCodeOJ;

public class LNRS {
    /*
     * http://dsqiu.iteye.com/blog/1701324
     * http://blog.csdn.net/hackbuteer1/article/details/7968623
     */

    /*
     * 最长重复子串 Longest Repeat Substring
     */

    /*
     * 最长重复子串 基本算法 O(n^3) 粗暴的 三重循环
     */

    static int comlen(String arr, int i, int j) {
        int len = 0;
        while (i < arr.length() && j < arr.length()
                && arr.charAt(i) == arr.charAt(j)) {
            ++len;
            i++;
            j++;
        }
        return len;
    }

    /*
     * 最长重复字符串
     */
    static void LRS_base(String arr) {
        int maxlen = 0; /* 记录最长重复子串长度 */
        int maxindex = 0; /* 记录最长重复子串的起始位置 */
        for (int i = 0; i < arr.length(); ++i) {
            for (int j = i + 1; j < arr.length(); ++j) {

                int len = comlen(arr, i, j);

                if (len > maxlen) {
                    maxlen = len;
                    maxindex = i;
                }
            }
        }
        System.out.println(maxindex);
        System.out.println(maxlen);
        System.out.println(arr.substring(maxindex, maxindex + maxlen));
    }

    /**
     * 方法二 就是 利用后缀数组：存放 以字符串中每个字符开头的后缀字符串 然后在排序， 这样就将 相邻的就比较相似了。 即 比较相邻的两个元素即可
     * 
     * O(N*N*logN)
     * 
     * 为"banana",该数组将表示这些后缀： a[0]:banana a[1]:anana a[2]:nana a[3]:ana a[4]:na
     * a[5]:a
     * 
     * 第二、对后缀数组进行快速排序，以将后缀相近的（变位词）子串集中在一起 qsort(a, n, sizeof(char*), pstrcmp)后
     * a[0]:a a[1]:ana a[2]:anana a[3]:banana a[4]:na a[5]:nana
     * 
     */

    /*
     * ===最长不重复子串====
     */

    /*
     * 就是i指向一个字符串的开始，用j指向第一个重复字符 那么 j-i 就是当前不重复字符串的长度 每次从i开始查找 ，就需要重新对visit数组 置0
     * 时间 O(n^2) 空间 O(1)
     */
    static void LNRS_hash(String arr) {
        System.out.println("=================");
        int maxlen = 0;
        int maxindex = 0;
        /* LNRS 基本算法 hash */
        int visit[] = new int[256];

        int i, j;
        for (i = 0; i < arr.length(); ++i) {
            // 访问数组标记为0;每次重新开始都复制为0
            for (int k = 0; k < visit.length; k++) {
                visit[k] = 0;
            }
            // 当前字符被访问 置 1
            visit[arr.charAt(i) - '0'] = 1;

            for (j = i + 1; j < arr.length(); ++j) {
                // 如果j开始的第一个字符未访问置 1
                if (visit[arr.charAt(j) - '0'] == 0) {
                    visit[arr.charAt(j) - '0'] = 1;
                } else {
                    // 如果出现重复字符，首先更新当前最长的字符串，然后退出i
                    // i 从下一个字符开始
                    if (j - i > maxlen) {
                        maxlen = j - i;
                        maxindex = i;
                    }
                    break;
                }
            }
            // 当以i开头的子串到结尾都没出现重复的，那么就要比较长短
            if ((j == arr.length()) && (j - i > maxlen)) {
                maxlen = j - i;
                maxindex = i;
            }
        }
        System.out.println("LNRS_hash " + arr );
        System.out.println(maxindex);
        System.out.println(maxlen);
        System.out.println(arr.substring(maxindex, maxindex + maxlen));
    }

    /*
     * LNRS dp 思路要清晰，才能写代码 时间 O(n^2) 空间 O(n)
     */
    // len 可以换成dp[i]

    static void LNRS_dp(String arr) {
        int dp[] = new int[arr.length()];
        int i, j;
        int last_start = 0; // 上一次最长不重复子串的起始位置
        int maxlen = 0, maxindex = 0;
        // int len = 1;
        /*
         * 以0结尾的字符串 最长不重复子串
         */
        dp[0] = 1;
        for (i = 1; i < arr.length(); ++i) {
            // 下面计算以 i 为结尾的最最长不重复的子串长度dp[i]
            // 所以要从 i -1 的位置开始比较 直到起始位置last_start
            for (j = i - 1; j >= last_start; --j) // 遍历到上一次最长子串起始位置
            {
                /*
                 * 本来是想利用dp[i-1]的最长不重复子串的
                 * dp[i-1]长度中的子串必定不重复,那么就要判断加上i字符如何？
                 * 所以就要判断i-1到开始中有无 与 i重复的？
                 * 有 ，退出比较；更新开始位置和以i结尾的最长不重复子串长度
                 * 无，直到开始位置dp[i] = dp[i-1] + 1;
                 */
                if (arr.charAt(j) == arr.charAt(i)) {
                    dp[i] = i - j;
                    // j 是和i 相等的位置，那么i结尾的最长不重复子串的开始肯定是j+1了。
                    last_start = j + 1; // 更新last_start
                    break;
                } else {
                    // 直到 开始位置还不想等，说明从j到i中没有重复的；否则要接着 判断相等与否
                    if (j == last_start) { // 无重复
                        dp[i] = dp[i - 1] + 1;
                    }
                }
            }
            if (dp[i] > maxlen)
            {
                maxlen = dp[i];
                maxindex = i + 1 - maxlen;
            }
        }
        System.out.println("LNRS_dp " + arr);
        System.out.println(maxindex);
        System.out.println(maxlen);
        System.out.println(arr.substring(maxindex, maxindex + maxlen));
        
    }

    /*
     * LNRS dp + hash 记录下标 时间O(n) 空间 O(n)
     */

    static void LNRS_dp_hash(String arr) {
        int[] dp = new int[arr.length()];
        int[] visit = new int[256];
        
        for (int i = 0; i < visit.length; i++) {
            visit[i] = -1;
        }
        int maxlen = 0, maxindex = 0;
        dp[0] = 1;
        int last_start = 0;// 最长无重复子串的起始位置

        // visit存放  最近访问的下标
        visit[arr.charAt(0) - '0'] = 0;

        for (int i = 1; i < arr.length(); ++i) {
            // 没有访问
            if (visit[arr.charAt(i) - '0'] == -1) {
                dp[i] = dp[i - 1] + 1;
                visit[arr.charAt(i) - '0'] = i; /* 记录字符下标 */
            } else {
                // 已经被访问
                /*
                 * 当前字符 已经出现重复 且 在最长无重复子串起始位置 之后 所以这个重复就要重新计算起始位置
                 */
                if (last_start <= visit[arr.charAt(i) - '0']) {
                    // visit[i] 是重复元素 离当前i最近的那个位置，他们是存放的同样的元素
                    dp[i] = i - visit[arr.charAt(i) - '0'];
                    last_start = visit[arr.charAt(i) - '0'] + 1;
                }
                /*
                 * 当前字符 已经出现重复但是 在最长无重复子串起始位置 之前
                 * 所以并不会记录之前的子串长度。虽然该字符之前出现过，但是在last_start 开始并没有出现。
                 * last_start之后截止到当前字符 并没有出现该字符的重复。
                 */
                else {
                    //abcaefdab 最后一个b的start就在e处，b在1位置出现了，但是start>1
                    dp[i] = dp[i - 1] + 1;
                }
                visit[arr.charAt(i) - '0'] = i; /* 更新最近重复位置 */
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                maxindex = i + 1 - maxlen;
            }
        }
        System.out.println("LNRS_dp_hash " + arr);
        System.out.println(maxindex);
        System.out.println(maxlen);
        System.out.println(arr.substring(maxindex, maxindex + maxlen));
    }

    /* LNRS dp + hash 优化 */
    /*
     * 时间O(n) 空间 O(1)
     */
    static void LNRS_dp_hash_impro(String arr) {
        int[] visit = new int[256];
        for (int i = 0; i < visit.length; i++) {
            visit[i] = -1;
        }
        int maxlen = 0, maxindex = 0;
        visit[arr.charAt(0) - '0'] = 0;
        int curlen = 1;
        int last_start = 0;

        for (int i = 1; i < arr.length(); ++i) {
            // 因为visit存放了字符的访问位置
            // 所以一旦重复，那么以i结尾的最大不重复子串就可以得到了.
            if (visit[arr.charAt(i) - '0'] == -1) {
                ++curlen;
                visit[arr.charAt(i) - '0'] = i; /* 记录字符下标 */
            } else {
                if (last_start <= visit[arr.charAt(i) - '0']) {
                    curlen = i - visit[arr.charAt(i) - '0'];
                    last_start = visit[arr.charAt(i) - '0'] + 1;
                } else {
                    ++curlen;
                }
                // 2016818更改到这个地方，以前出错了
                // 重复了不管如何都要首先更新最新的位置信息
                visit[arr.charAt(i) - '0'] = i; /* 更新最近重复位置 */
            }
            // 更新最长子串长度
            if (curlen > maxlen) {
                maxlen = curlen;
                maxindex = i + 1 - maxlen;
            }
        }
        System.out.println("LNRS_dp_hash_impro " + arr);
        System.out.println(maxindex);
        System.out.println(maxlen);
        System.out.println(arr.substring(maxindex, maxindex + maxlen));
    }

    public static void main(String[] args) {
        String arr = "axbdebpqawuva";// "ask not what your country can do for you,but what youcan do for your country";
        LRS_base(arr);
        // "axbdebpqawuva";// axbdebpqawuva
        System.out.println("最长不重复子串");
        LNRS_hash(arr);
        LNRS_dp(arr);
        LNRS_dp_hash(arr);
        LNRS_dp_hash_impro(arr);

    }
}
