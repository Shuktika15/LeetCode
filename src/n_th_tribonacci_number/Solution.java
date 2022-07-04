package n_th_tribonacci_number;

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 3; i < n + 1; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}