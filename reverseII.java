package LeetCodeOJ;
/*
 * Reverse Words in a String II leetcode 186
 * For example,
   "the sky is blue",
   "blue is sky the".
 */
public class reverseII {
    /**
     * 思想就是利用旋转的方法，组个单词翻转
     * @param str
     * @return
     */
    public static String reverseStr(String str){
        char [] ch = str.toCharArray();
        swap(ch, 0, ch.length - 1);
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
        String input = "Let's take LeetCode contest";
        System.out.println(reverseStr(input));
    }
}
