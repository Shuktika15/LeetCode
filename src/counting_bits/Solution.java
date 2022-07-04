package counting_bits;

class Solution {
    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int c = 0, j = i;
            while (j != 0) {
                j = j & (j - 1);
                c++;
            }
            a[i] = c;
        }
        return a;
    }
}