class Solution {
    private int m;
    private int n;

    private long dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        
        long currentSum = grid[i][j];
        grid[i][j] = 0;
        
        currentSum += dfs(i - 1, j, grid);
        currentSum += dfs(i + 1, j, grid);
        currentSum += dfs(i, j - 1, grid);
        currentSum += dfs(i, j + 1, grid);
        
        return currentSum;
    }

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int islandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long totalValue = dfs(i, j, grid);
                    if (totalValue % k == 0) {
                        islandCount++;
                    }
                }
            }
        }
        
        return islandCount;
    }
}