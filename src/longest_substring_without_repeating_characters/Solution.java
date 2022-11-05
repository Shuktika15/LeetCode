package longest_substring_without_repeating_characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int start = 0, end = 0;

        int[] chars = new int[128];

        while (end < s.length()) {
            char right = s.charAt(end);
            chars[right]++;

            // contract the window size until unique characters window is formed
            while (chars[right] > 1) {
                chars[s.charAt(start)]--;
                start++;
            }

            max = Math.max(max, end - start + 1);

            end++;
        }
        return max;
    }
}