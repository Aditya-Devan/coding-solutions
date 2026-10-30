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