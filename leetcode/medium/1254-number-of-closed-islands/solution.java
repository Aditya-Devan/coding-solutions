
class Solution {
    int m, n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int r, int c) {
        // If it goes out of bounds, this island touches the edge (not closed)
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }

        // If it hits water (1) or visited land, it's bounded on this path
        if (grid[r][c] == 1) {
            return true;
        }

        // Mark the current cell as visited by changing 0 to 1
        grid[r][c] = 1;

        // Traverse all 4 directions. 
        // Note: We use bitwise AND or evaluate all branches so that DFS fully explores 
        // and marks the entire island even if one direction hits the boundary early.
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);
        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);

        return left && right && up && down;
    }
}