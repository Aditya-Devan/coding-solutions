class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] ans = new int[2];

        traverse(0, 0, vis, grid, ans);
        return ans;
    }

    public void traverse(int i, int j, boolean[][] vis,
                         char[][] grid, int[] ans) {
        int n = grid.length;
        int m = grid[0].length;

        vis[i][j] = true;
        char ch = grid[i][j];

        int ni = i, nj = j;

        if (ch == 'R') {
            nj++;
        } else if (ch == 'L') {
            nj--;
        } else if (ch == 'U') {
            ni--;
        } else if (ch == 'D') {
            ni++;
        }

        // Stop if the next move is invalid or revisits a cell.
        if (!isValid(ni, nj, n, m) || vis[ni][nj]) {
            ans[0] = i;
            ans[1] = j;
            return;
        }

        traverse(ni, nj, vis, grid, ans);
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}