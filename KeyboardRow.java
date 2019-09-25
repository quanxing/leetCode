package LeetCodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 500 Given a List of words, return the words that can be typed using
 * letters of alphabet on only one row's of American keyboard like the image
 * below.
 * 
 * @author fqx
 *
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        //prepare the map
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("qwertyuiop", 0);
        map.put("asdfghjkl", 1);
        map.put("zxcvbnm", 2);

        ArrayList<String> arr = new ArrayList<String>();
        //store the result
        for (int i = 0; i < words.length; i++) {
            if(isSameLayer(words[i], map)){
                arr.add(words[i]);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }

    public boolean isSameLayer(String str, HashMap<String, Integer> map) {
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = 0;
            //search each character of the str in these map.entrySet()
            for (; i < str.length(); i++) {
                if (entry.getKey().indexOf(Character.toLowerCase(str.charAt(i))) != -1) {
                    continue;
                }else{
                    break;
                }
            }
            // only if every character of the str exist in the same key in map
            //namely i == str.length(), find it.
            if(i == str.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        String [] result = new KeyboardRow().findWords(words);
        System.out.println(Arrays.toString(result));
    }

}
