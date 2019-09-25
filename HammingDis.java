package LeetCodeOJ;

public class HammingDis {
    /*
     * leetcode 汉明距离 Hadmming Distance 461?
     */
    int BinaryCount(int n){
        int count  = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    
    public int HD (int x, int y){
        int c = x ^ y;
        return BinaryCount(c);
    }
    
    public static void main(String[] args) {
        System.out.println(new HammingDis().HD(1, 4));
    }
}
