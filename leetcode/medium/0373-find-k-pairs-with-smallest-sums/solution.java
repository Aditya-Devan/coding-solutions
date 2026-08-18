class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

      
        for(int j = 0; j < nums2.length && j < k; j++) {
            minHeap.offer(new int[]{nums1[0] + nums2[j], 0, j});
        }

       
        while(k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[1], j = cur[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if(i + 1 < nums1.length) {
                minHeap.offer(new int[]{nums1[i+1] + nums2[j], i+1, j});
            }
        }

        return ans;
    }
}
