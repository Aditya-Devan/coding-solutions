class Solution {
    public int minGroups(int[][] intervals) {
      Arrays.sort(intervals , (a,b)->(a[0]-b[0])); 
      PriorityQueue<Integer> pq=new PriorityQueue<>();

      int len=intervals.length;
      for(int i=0;i<len;i++){
        int currStart=intervals[i][0];
        int currEnd=intervals[i][1];
        if(pq.isEmpty()) {
            pq.offer(currEnd);
            continue;
        }else if(pq.peek() < currStart){
            pq.poll();
        }
           pq.offer(currEnd);
      }

      return pq.size();

    }
}