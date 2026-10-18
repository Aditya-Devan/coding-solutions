# N-Queens

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

The  **n-queens**  puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return  *all distinct solutions to the  **n-queens puzzle***. You may return the answer in  **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

 

 **Example 1:** 

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

```

 **Example 2:** 

```
Input: n = 1
Output: [["Q"]]

```

 

 **Constraints:** 

- 1 <= n <= 9

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 36.14%)  
**Memory:** 46 MB (beats 97.50%)  
**Submitted:** 2026-10-18T07:14:39.209Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/n-queens/)