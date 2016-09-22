package LeetCodeOJ;

import java.util.*;

/*
 * leetcode282
 * 
 */
public class ExAddOp {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        String[] op = { "+", "-", "*" };
        if (num.length() == 1)
            return list;
        for (int i = 0; i < op.length; i++) {

        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(",");
            if (input.length == 2) {
                String opNum = input[0];
                int target = Integer.parseInt(input[1]);
                System.out.println(new ExAddOp().addOperators(opNum, target));
            } else {
                break;
            }
        }
    }
}
