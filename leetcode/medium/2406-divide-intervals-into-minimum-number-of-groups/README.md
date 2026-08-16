# Divide Intervals Into Minimum Number of Groups

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array `intervals` where `intervals[i] = [lefti, righti]` represents the  **inclusive**  interval `[lefti, righti]`.

You have to divide the intervals into one or more  **groups**  such that each interval is in  **exactly**  one group, and no two intervals that are in the same group  **intersect**  each other.

Return  *the  **minimum**  number of groups you need to make*.

Two intervals  **intersect**  if there is at least one common number between them. For example, the intervals `[1, 5]` and `[5, 8]` intersect.

 

 **Example 1:** 

```
Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.

```

 **Example 2:** 

```
Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
Output: 1
Explanation: None of the intervals overlap, so we can put all of them in one group.

```

 

 **Constraints:** 

- 1 <= intervals.length <= 105
- intervals[i].length == 2
- 1 <= lefti <= righti <= 106

## Solution

**Language:** Java  
**Runtime:** 98 ms (beats 43.45%)  
**Memory:** 114.4 MB (beats 27.48%)  
**Submitted:** 2026-08-16T15:42:20.900Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/)