package unique_paths;

class Solution {
    private int uniquePaths(int i, int j, int m, int n, int[][] mem) {
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1;
        if (mem[i][j] != 0) return mem[i][j];
        mem[i][j] = uniquePaths(i + 1, j, m, n, mem) + uniquePaths(i, j + 1, m, n, mem);
        return mem[i][j];
    }

    public int uniquePaths(int m, int n) {
        return uniquePaths(0, 0, m - 1, n - 1, new int[m][n]);
    }
}
