class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();
        
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]}); 
        }
        
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
       
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0); 
        
        int prevMaxHeight = 0;
        
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            
            if (h < 0) {
                pq.offer(-h);
            } else {
                pq.remove(h);
            }
            
            int currentMaxHeight = pq.peek();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        
        return result;
    }
}