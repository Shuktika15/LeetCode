package palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        int n = x, r, s = 0;
        while (x > 0) {
            r = x % 10;
            s = s * 10 + r;
            x /= 10;
        }
        return s == n;
        //Oneliner
        // return x >= 0 && new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x));
    }
}