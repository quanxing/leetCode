package LeetCodeOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RomanToint {
    //为啥这个是7ms
    public int romanToInt1(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
    //130ms
    public int romanToInt(String s) {
        // 不考虑输入罗马数字不合法的情况
        /*
         * 1 如果左数字 < 右边数字 那么做减法 Ⅳ= 4;Ⅸ= 9；
         * 2 如果左数字 >= 右边数字 加法 VI=6, Ⅷ = 8; Ⅻ = 12; Ⅲ = 3;
         */
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 15);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char [] c = s.toCharArray();
        int sum = 0;
        System.out.println(c[0]);
        char cc = c[0];
        String ss = Character.toString(cc);
        System.out.println(map.get(String.valueOf(c[0])));
        for (int i = 0; i < c.length; i++){
            //如果是最后一个元素，则加上即可
            if ( i == c.length - 1||map.get(String.valueOf(c[i])) >= map.get(String.valueOf(c[i+1])) ){
                sum += map.get(String.valueOf(c[i]));
            }else{
                sum -= map.get(String.valueOf(c[i]));
            }
        }
        return sum;
    }
    //这个我目前还没想到要干啥
    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i+1);
                switch (nextChar) {
                    case '\"': sb.append('\"'); break;
                    case '/' : sb.append('/'); break;
                    case '\\': sb.append('\\'); break;
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'r' : sb.append('\r'); break;
                    case 'n' : sb.append('\n'); break;
                    case 't' : sb.append('\t'); break;
                    default: break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new RomanToint().romanToInt1(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
