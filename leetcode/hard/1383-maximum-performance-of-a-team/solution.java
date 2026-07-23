class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final long MOD = 1_000_000_007L;

        int[][] combine = new int[n][2];
        for (int i = 0; i < n; i++) {
            combine[i][0] = speed[i];
            combine[i][1] = efficiency[i];
        }

        Arrays.sort(combine, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long maxPerformance = 0;

        for (int i = 0; i < n; i++) {
            sum += combine[i][0];
            pq.offer(combine[i][0]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            maxPerformance = Math.max(maxPerformance, sum * (long) combine[i][1]);
        }

        return (int) (maxPerformance % MOD);
    }
}