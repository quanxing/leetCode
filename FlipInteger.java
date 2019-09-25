package LeetCodeOJ;

import offer.constructArray52;

/**
 * leetcode 476 Number Complement Given a positive integer, output its
 * complement number. The complement strategy is to flip the bits of its binary
 * representation. Example 1: Input: 5 Output: 2 Explanation: The binary
 * representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2. Example 2: Input: 1 Output: 0 Explanation: The
 * binary representation of 1 is 1 (no leading zero bits), and its complement is
 * 0. So you need to output 0.
 * 
 * @author fqx
 *
 */
public class FlipInteger {

    public static int findComplement(int n) {
        String a = Integer.toBinaryString(n);
        int i = 0;
        for (i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }
        char[] ch = a.substring(i).toCharArray();
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '0') {
                ch[j] = '1';
            } else {
                ch[j] = '0';
            }
        }

        int result = Integer.parseInt(new String(ch), 2);
        return result;

    }

    /*
     * 别人的算法
     */

    public int findComplement_1(int num) {
        if (num == 0) {
            return 0;
        }
        //正数左移 直到 等于0 说明，非零部分全部移出。
        int count = 0;
        while (num > 0) {
            num = num << 1;
            count++;
        }
        //只截取正数中从高位开始碰到第一个1的后面的所有二进制
        num = num >> count;
            
            
        //负数 直接取反，因为负数存储的是补码 ，高位全部shi
        num = ~num;
        return num;
    }

    /*
     * 计算机天才们的想法
     */
    public int findComplete_2(int num){
        int leftmost = Integer.highestOneBit(num);
        int mask = ( leftmost << 1) - 1;
        num = ~num;
        return num & mask;
        
/*      int mask = 1;
        while (mask < num) mask = (mask << 1) | 1;
        return ~num & mask;*/
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findComplement(-5));
        System.out.println(new FlipInteger().findComplement_1(-5));
        System.out.println(new FlipInteger().findComplete_2(-5));
    }

}
