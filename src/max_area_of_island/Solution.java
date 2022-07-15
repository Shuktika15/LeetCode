package max_area_of_island;

class Solution {
    public int bfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == -1 || grid[r][c] == 0) {
            return 0;
        } else {
            grid[r][c] = -1;
            return 1 + bfs(r - 1, c, grid) + bfs(r + 1, c, grid) + bfs(r, c - 1, grid) + bfs(r, c + 1, grid);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = bfs(i, j, grid);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}