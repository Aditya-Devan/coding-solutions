class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val); 
        }

        int[] bestRange = new int[]{-100000, 100000}; 

        while (minHeap.size() == nums.size()) { 
            int[] curr = minHeap.poll();
            int minVal = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];

            if (currentMax - minVal < bestRange[1] - bestRange[0]) {
                bestRange[0] = minVal;
                bestRange[1] = currentMax;
            }

            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                currentMax = Math.max(currentMax, nextVal); 
            } else {
                break; 
            }
        }

        return bestRange;
    }
}