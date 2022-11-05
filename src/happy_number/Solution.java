package happy_number;

class Solution {
    private int squareSum(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        int slow = squareSum(n);
        int fast = squareSum(squareSum(n));
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }
}
