class Solution {
    public int minRotations(int n ,String s) {

        int total = dist(0, s.charAt(0) - '0');

        for (int i = 1; i < n; i++) {
            total += dist(s.charAt(i - 1) - '0', s.charAt(i) - '0');
        }

        int ans = total;

        int reversedStart = s.charAt(n - 1) - '0';
        int originalStart = s.charAt(0) - '0';

        ans = Math.min(
            ans,
            total - dist(0, originalStart) + dist(0, reversedStart)
        );

        // k > 0: only the boundary changes
        int last = s.charAt(n - 1) - '0';

        for (int k = 1; k < n; k++) {
            int prev = s.charAt(k - 1) - '0';
            int current = s.charAt(k) - '0';

            int newCost = total
                    - dist(prev, current)
                    + dist(prev, last);

            ans = Math.min(ans, newCost);
        }

        return ans;
    }

    private int dist(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }
}