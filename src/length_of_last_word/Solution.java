package length_of_last_word;

class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        s = s.trim(); // Trims spaces from the beginning and end of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }
}
