# Shortest Path With At Most K Consecutive Identical Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer `n` representing the number of nodes in a  **directed weighted**  graph, numbered from 0 to `n - 1`. This is represented by a 2D integer array `edges`, where `edges[i] = [ui, vi, wi]` represents a directed edge from node `ui` to node `vi` with weight `wi`.

You are also given a string `labels` of length `n`, where `labels[i]` is the character assigned to node `i`, and an integer `k`.

Return the  **minimum**   **total**  edge weight of a path from node 0 to node `n - 1` such that the concatenation of the labels of the nodes along the path contains  **at most**  `k`  **consecutive**   **identical**  characters. If no valid path exists, return -1.

 

 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1],[0,2,3]], labels = "aab", k = 1

 **Output:**  3

 **Explanation:** 

The optimal valid path from node 0 to node 2 is as follows:

- Use edges[2] = [0, 2, 3] to reach node 2 with a weight wi = 3.
The corresponding concatenation of labels is `"ab"`, which satisfies at most `k = 1` consecutive identical characters. Thus, the answer is 3.

 **Example 2:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1],[0,2,3]], labels = "aab", k = 2

 **Output:**  2

 **Explanation:** 

The optimal valid path from node 0 to node 2 is as follows:

- Use edges[0] = [0, 1, 1] to reach node 1 with weight wi = 1.
- Use edges[1] = [1, 2, 1] to reach node 2 with weight wi = 1.
The corresponding concatenation of labels is `"aab"`, which satisfies at most `k = 2` consecutive identical characters. Thus, the answer is 2.

 **Example 3:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1]], labels = "aaa", k = 2

 **Output:**  -1

 **Explanation:** 

There is no valid path from node 0 to node 2 that satisfies at most `k = 2` consecutive identical characters. Thus, the answer is -1.

 

 **Constraints:** 

- 1 <= n == labels.length <= 5 * 104
- 0 <= edges.length <= 5 * 104
- edges[i] == [ui, vi, wi]
- 0 <= ui, vi <= n - 1
- ui != vi
- 1 <= wi <= 104
- labels consists of lowercase English letters
- 1 <= k <= 50

## Solution

**Language:** Java  
**Runtime:** 2 ms  
**Memory:** 41.7 MB  
**Submitted:** 2026-10-30T15:05:59.377Z  

```java
import java.util.*;

class Solution {

    static class EdgeInfo {
        int target;
        int weight;

        public EdgeInfo(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Memoization table: memo[node][streak] stores the minimum weight to reach the end from this state
    private Map<String, Integer> memo;

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<EdgeInfo>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new EdgeInfo(edge[1], edge[2]));
        }

        memo = new HashMap<>();
        
        // Start DFS from node 0, with initial streak = 1 (since node 0's label appears once)
        int ans = dfs(0, 1, n, adj, labels, k);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int currNode, int streak, int n, List<List<EdgeInfo>> adj, String labels, int k) {
        // Base case: reached destination node
        if (currNode == n - 1) {
            return 0;
        }

        // State representation for memoization
        String stateKey = currNode + "," + streak;
        if (memo.containsKey(stateKey)) {
            return memo.get(stateKey);
        }

        int minWeight = Integer.MAX_VALUE;

        for (EdgeInfo edge : adj.get(currNode)) {
            int nextNode = edge.target;
            int weight = edge.weight;

            char currChar = labels.charAt(currNode);
            char nextChar = labels.charAt(nextNode);

            int nextStreak;
            if (currChar == nextChar) {
                nextStreak = streak + 1;
            } else {
                nextStreak = 1; // Reset streak if character changes
            }

            // Prune branches that exceed k consecutive identical characters
            if (nextStreak <= k) {
                int res = dfs(nextNode, nextStreak, n, adj, labels, k);
                if (res != Integer.MAX_VALUE) {
                    minWeight = Math.min(minWeight, weight + res);
                }
            }
        }

        memo.put(stateKey, minWeight);
        return minWeight;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/)