package LeetCodeOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseInt {
    
//    public static int reverse(int x){
//        int flag = 0;
//        if (x < 0){
//            flag = 1;
//            x = -1 * x;
//        }
//        long sum = 0;
//        long n =  String.valueOf(x).length();
//        int i = 0;
//        while((x % 10) !=0  ||  i != n){
//            sum += (x % 10) * Math.pow(10,  n - i - 1);
//            x = x / 10;
//            i += 1;
//        }
//        if (flag == 1){
//            sum = -1 * sum;
//        }
//        return sum >Math.pow(2, 31) - 1||sum <-Math.pow(2, 31)? 0: (int)sum;
//    }
    public static int reverse(int x){
        long sum = 0;
        while(x !=0){
            sum = sum * 10 + x %10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int)sum;
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new reverseInt().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }

}
