package plus_one;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        for (int i = n; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] new_digits = new int[n + 2];
        new_digits[0] = 1;
        return new_digits;
    }
}
