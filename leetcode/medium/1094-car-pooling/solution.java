class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        
        // Sort trips by start location
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        
        // MinHeap to track drop-offs (end location)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        int i = 0;
        int locs = 0;

        while (i < n || !minHeap.isEmpty()) {
            // If no active trips, jump to next trip's start
            if (minHeap.isEmpty()) {
                locs = trips[i][1];
            }

            // Drop passengers at this location
            while (!minHeap.isEmpty() && minHeap.peek()[1] == locs) {
                capacity += minHeap.poll()[0];
            }

            // Board new passengers at this location
            while (i < n && trips[i][1] == locs) {
                if (capacity >= trips[i][0]) {
                    capacity -= trips[i][0];
                    minHeap.offer(new int[]{trips[i][0], trips[i][2]});
                } else {
                    return false;
                }
                i++;
            }

            // Move to next location: either next trip start or next drop
            if (!minHeap.isEmpty()) {
                locs = Math.min(
                    i < n ? trips[i][1] : Integer.MAX_VALUE,
                    minHeap.peek()[1]
                );
            } else if (i < n) {
                locs = trips[i][1];
            }
        }
        return true;
    }
}
