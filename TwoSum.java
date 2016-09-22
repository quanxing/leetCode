package LeetCodeOJ;

import java.util.Hashtable;

public class TwoSum {
    public static int[] towSum(int[] numbers, int target) {
        int a[] = new int[2];
        Hashtable<Integer, Integer> num = new Hashtable<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (num.containsKey(numbers[i])) {
                a[0] = num.get(numbers[i]) + 1;
                a[1] = i + 1;
                break;
            }
            num.put(target - numbers[i], i);
        }
        return a;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = towSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
