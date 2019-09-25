package LeetCodeOJ;
/*
 * Reverse Words in a String leetcode 557
 */
public class reverseWords {
    /**
     * 思想就是碰到空格后，先将前面的逆序，依次进行
     * @param str
     * @return
     */
    public static String reverseStr(String str){
        char [] ch = str.toCharArray();
        int space  = -1;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == ' '){
                int nextSpace = i;
                swap(ch, space+1, nextSpace - 1);
                space = nextSpace;
            }
        }
        swap(ch, space+1, ch.length - 1);
        return new String(ch);
    }
    public static void swap(char [] ch, int start, int end ){
        while(start < end){
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "Let's take LeetCode contest";
        System.out.println(reverseStr(input));
    }

}
