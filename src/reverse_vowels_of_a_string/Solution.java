package reverse_vowels_of_a_string;

import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder string = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i < j; ) {
            while (!set.contains(s.charAt(i)) && i < j) {
                i++;
            }
            while (!set.contains(s.charAt(j)) && i < j) {
                j--;
            }

            string.setCharAt(i, s.charAt(j));
            string.setCharAt(j, s.charAt(i));
            i++;
            j--;
        }

        return string.toString();
    }
}
