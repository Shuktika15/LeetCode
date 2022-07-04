package roman_to_integer;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int len = s.length() - 1;
        char[] chars = s.toCharArray();
        int num = map.get(chars[len]);
        if (len == 0) {
            return num;
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = map.get(chars[i]);
            int temp1 = map.get(chars[i + 1]);
            if (temp < temp1) {
                num -= temp;
            } else {
                num += temp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
