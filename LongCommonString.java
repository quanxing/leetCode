package LeetCodeOJ;

import java.util.Stack;

//最长公共子串和最长公共子序列

/*
 * http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
 * 这是一个系列的题目：关于字符串的需要总结
 * 类似字符串模式匹配
 */

public class LongCommonString {

    /*
     * 最长公共子串 要求连续
     */
    // 最朴素的解法O(n^3)
    static void LCSub(String s1, String s2) {
        String max = s1.length() >= s2.length() ? s1 : s2;
        String min = s1.length() >= s2.length() ? s2 : s1;
        int l = 0;
        String s = "";
        for (int i = 0; i < min.length(); i++) {
            for (int j = i + 1; j <= min.length(); j++) {
                // j-i>l 这个就保证了出现了最长长度相等，值保留最先出现的那个子串
                if (max.contains(min.substring(i, j)) && j - i > l) {
                    l = j - i;
                    s = min.substring(i, j);
                    System.out.println(s);
                }
            }
        }
        System.out.println(s);
    }

    // 动态规划的解法

    static void longestCommonSubString(char[] c1, char[] c2) {
        // 存放二维数组 第一行，第一列的所有元素始终为0;
        int[][] len = new int[c1.length + 1][c2.length + 1];

        // 最长重复子串的长度
        int max = -1;
        // i, j都变成了 第几个元素了
        int i, j;
        int x = 0, y = 0;
        for (i = 1; i < c1.length + 1; i++) {
            for (j = 1; j < c2.length + 1; j++) {
                // i-1才是下标
                if (c1[i - 1] == c2[j - 1]) {
                    len[i][j] += len[i - 1][j - 1] + 1;
                } else {
                    len[i][j] = 0;
                }

                if (len[i][j] > max) {
                    max = len[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("最长公共子串的长度为:" + max);
        // x - max ---- x - 1 
        // y - max ----- y - 1

        String sub = "";
        for (int k = x - max; k < x; k++) {
            sub += c1[k];
        }
        System.out.println(sub);
    }
    // public static final native int iii = 0;

    /*
     * 题目：如果字符串一的所有字符按其在字符串中的顺序出现在另外一个字符串二中，
     * 则字符串一称之为字符串二的子串。注意，并不要求子串（字符串一）的字符必须连续出现在字符串二中。
     * 请编写一个函数，输入两个字符串，求它们的最长公共子序列，并打印出最长公共子序列。
     * 
     * 对应位置出现了同样的字符；找出所有的字符就是最长公共子序列
     */
    public static int[][] LCS(String str1, String str2) {
        int len = 0, endx = 0,endy = 0;
        int[][] opt = new int[str1.length() + 1][str2.length() + 1];
        
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
           
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                } else {
                    opt[i][j] = (opt[i - 1][j] >= opt[i][j - 1] ? opt[i - 1][j]
                            : opt[i][j - 1]);
                }
                
                if(len <= opt[i][j]){
                    len = opt[i][j];
                    endx = i;
                    endy = j;
                    System.out.print(len + " " + endx + " " + endy);
                    System.out.println();
                }
            }
        }
        System.out.println("最长公共子序列:" + len+" "+(endx-1)+" "+(endy-1));
        //直接从此处返回最长的公共自序列
        Stack<Character> st = new Stack<Character>();
        while(len -- > 0 ){
            if(str1.charAt(endx - 1) == str2.charAt(endy -1)){
                System.out.println((endx-1)+" " + (endy-1));
                st.push(str1.charAt(endx-1));
                endx = endx-1;
                endy = endy-1;
            }else{
                if(opt[endx-1][endy] > opt[endx][endy-1]){
                    endx = endx-1;
                    endy = endy;
                }else{
                    endy = endy-1;
                    endx = endx;
                }
                len++;
            }
        }
        
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }
        System.out.println();
        return opt;
    }
    public static void print(int[][] opt, String X, String Y, int i, int j,
            StringBuilder str) {

        // i ,j 开始为字符串的长度，随后也指的是 长度，不是下标，减一 才是下标
        if (i == 0 || j == 0) {
            return;
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            str.append(X.charAt(i - 1));
            print(opt, X, Y, i - 1, j - 1, str); // don't put this line before
                                                 // the
            // upper line. Otherwise, the order
            // is wrong.
        } else if (opt[i - 1][j] >= opt[i][j]) {
            print(opt, X, Y, i - 1, j, str);
        } else {
            print(opt, X, Y, i, j - 1, str);
        }
    }

    public static void main(String[] args) {
        longestCommonSubString("GCCCTAGCG".toCharArray(),
                "GCGCAATG".toCharArray());

        int[][] opt = LCS("BDCABA", "ABCBDAB");
        int row = opt.length;
        int col = opt[0].length;
        int len = opt[row - 1][col - 1];
        System.out.println("最长的公共子序列长度：" + len);
        StringBuilder sb = new StringBuilder();
        print(opt, "BDCABA", "ABCBDAB", "BDCABA".length(),
                "ABCBDAB".length(), sb);

        System.out.println(sb.reverse().toString());

    }
}
