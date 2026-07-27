class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.offer(i);
            if(pq.size()>2){
                pq.poll();
            }
        }
        int l1=pq.poll()-1;
        int l2=pq.poll()-1;
        return l1*l2;
    }
}