
class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        if (n < 3) return -1;

        int V = 2000;
        int INF = 1_000_000_000;

        // Left DP:
        // Minimum cost to make [0...i] strictly increasing,
        // with nums[i] = j.

        int[][] dpl = new int[n][V + 1];

        for (int[] row : dpl) {
            java.util.Arrays.fill(row, INF);
        }

        // Base case
        for (int j = 1; j <= V; j++) {
            dpl[0][j] = Math.abs(nums[0] - j);
        }

        // Build Left DP using running minimum
        for (int i = 1; i < n; i++) {

            int minCost = INF;

            for (int j = 1; j <= V; j++) {

                dpl[i][j] = minCost + Math.abs(nums[i] - j);

                minCost = Math.min(minCost, dpl[i - 1][j]);
            }
        }

        // Right DP:
        // Minimum cost to make [i...n-1] strictly decreasing,
        // with nums[i] = j.

        int[][] dpr = new int[n][V + 1];

        for (int[] row : dpr) {
            java.util.Arrays.fill(row, INF);
        }

        // Base case
        for (int j = 1; j <= V; j++) {
            dpr[n - 1][j] = Math.abs(nums[n - 1] - j);
        }

        // Build Right DP using running minimum
        for (int i = n - 2; i >= 0; i--) {

            int minCost = INF;

            for (int j = 1; j <= V; j++) {

                dpr[i][j] = minCost + Math.abs(nums[i] - j);

                minCost = Math.min(minCost, dpr[i + 1][j]);
            }
        }

        // Combine Left DP + Peak + Right DP

        int answer = INF;

        for (int i = 1; i <= n - 2; i++) {

            int leftMin = INF;
            int rightMin = INF;

            for (int j = 1; j <= V; j++) {

                // Minimum left/right cost for values k < j
                leftMin = Math.min(leftMin, dpl[i - 1][j - 1]);
                rightMin = Math.min(rightMin, dpr[i + 1][j - 1]);

                int peakCost = Math.abs(nums[i] - j);

                int totalCost = leftMin + peakCost + rightMin;

                answer = Math.min(answer, totalCost);
            }
        }

        return answer >= INF ? -1 : answer;
    }
}
