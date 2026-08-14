# Find Median from Data Stream

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

The  **median**  is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

- For example, for arr = [2,3,4], the median is 3.
- For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

- MedianFinder() initializes the MedianFinder object.
- void addNum(int num) adds the integer num from the data stream to the data structure.
- double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

 

 **Example 1:** 

```
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

```

 

 **Constraints:** 

- -105 <= num <= 105
- There will be at least one element in the data structure before calling findMedian.
- At most 5 * 104 calls will be made to addNum and findMedian.

 

 **Follow up:** 

- If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
- If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

## Solution

**Language:** Java  
**Runtime:** 125 ms (beats 86.92%)  
**Memory:** 111.6 MB (beats 37.73%)  
**Submitted:** 2026-08-14T11:10:39.009Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/find-median-from-data-stream/)