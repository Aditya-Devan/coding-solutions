class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long n1Sum = 0;
        long res = 0;

        for (int[] pair : pairs) {
            int n1 = pair[0];
            int n2 = pair[1];

            n1Sum += n1;
            minHeap.offer(n1);

            if (minHeap.size() > k) {
                n1Sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                res = Math.max(res, n1Sum * (long) n2);
            }
        }

        return res;
    }
}
