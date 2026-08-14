/* 
class MedianFinder {
    
    PriorityQueue<Integer> small=new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> large=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       if(small.isEmpty() && large.isEmpty()){
        small.offer(num);
       }else if(num>=small.peek()){
         large.offer(num);
       }else{
         small.offer(num);
       } 

       int s1=small.size();
       int s2=large.size();
       if(Math.abs(s1-s2)>1){
           if(s1>s2){
            large.offer(small.poll());
           }else{
            small.offer(large.poll());
           }
       }

    }
    
    public double findMedian() {
        int s1=small.size();
        int s2=large.size();
         if(s1==s2){
            return (double)(small.peek()+large.peek())/2;
         }else{
            if(s1>s2) return small.peek();
            else return large.peek();
         }
    }
}


 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


class MedianFinder {
  
    private final PriorityQueue<Integer> small;
    private final PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else if (small.size() > large.size()) {
            return small.peek();
        } else {
            return large.peek();
        }
    }
}