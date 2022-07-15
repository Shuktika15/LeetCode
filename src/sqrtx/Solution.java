package sqrtx;

class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long mid = x / 4;
        long end = x / 2;
        while (start <= end) {
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        return (int) start;
    }
}