package get_maximum_in_generated_array;

class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        int max = 0;
        if (n < 2)
            return n;
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
}