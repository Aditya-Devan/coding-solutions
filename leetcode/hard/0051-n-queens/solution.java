class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
        Set<Integer> visCol = new HashSet<>();
        solve(grid, n, 0, ans, visCol);
        return ans;
    }

    public void solve(char[][] grid, int n, int row, List<List<String>> ans, Set<Integer> visCol) {
        if (row == n) {
            List<String> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ls.add(new String(grid[i]));
            }
            ans.add(ls);
            return;
        }

        for (int j = 0; j < n; j++) {
            // Check if column and diagonals are safe before placing
            if (!visCol.contains(j) && isSafe(grid, row, j)) {
                grid[row][j] = 'Q';
                visCol.add(j);
                
                solve(grid, n, row + 1, ans,visCol);
                
                // Backtrack
                grid[row][j] = '.';
                visCol.remove(j);
            }
        }
    }

    public boolean isSafe(char[][] grid, int row, int col) {
        int n = grid.length;
        
        // Check upper-left diagonal
        int r = row - 1, c = col - 1;
        while (r >= 0 && c >= 0) {
            if (grid[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check upper-right diagonal
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (grid[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}