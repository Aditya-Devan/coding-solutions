class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] details = new int[n][2];

        for (int i = 0; i < n; i++) {
            details[i][0] = capital[i]; 
            details[i][1] = profits[i]; 
        }

     
        Arrays.sort(details, (a, b) -> a[0] - b[0]);

       
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int i = 0;
        while (k > 0) {
            while (i < n && details[i][0] <= w) {
                maxHeap.offer(details[i]);
                i++;
            }

            if (maxHeap.isEmpty()) break;

            w += maxHeap.poll()[1];
            k--;
        }

        return w; 
    }
}
