package LeetCodeOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class palindrome {
    public boolean isPalindrome(int x) {
        // 负数不能
        //其次就是尾数为0的数字，否则首数字也为0
        //1221 ; 12321
        /*
         * 1221 ==> x=sum
         * 奇数 12321 ==> x < sum but x % 10 == sum
         */
        if(x < 0 || x!=0 && x %10==0){
            return false;
        }
        long sum = 0;
        while(x > sum){ // 知道x < sum 时退出，因为 x<sum时，再取余sum >> x了
            sum = sum * 10 + x %10;
            x = x / 10;
        }
        return x==sum || x == sum/10? true:false;
    }
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            boolean ret = new palindrome().isPalindrome(x);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}
