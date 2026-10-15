# Number of Visible People in a Queue

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are `n` people standing in a queue, and they numbered from `0` to `n - 1` in  **left to right**  order. You are given an array `heights` of  **distinct**  integers where `heights[i]` represents the height of the `ith` person.

A person can  **see**  another person to their right in the queue if everybody in between is  **shorter**  than both of them. More formally, the `ith` person can see the `jth` person if `i < j` and `min(heights[i], heights[j]) > max(heights[i+1], heights[i+2],..., heights[j-1])`.

Return  *an array* `answer` *of length* `n` *where* `answer[i]` *is the  **number of people**  the* `ith` *person can  **see**  to their right in the queue*.

 

 **Example 1:** 

```
Input: heights = [10,6,8,5,11,9]
Output: [3,1,2,1,1,0]
Explanation:
Person 0 can see person 1, 2, and 4.
Person 1 can see person 2.
Person 2 can see person 3 and 4.
Person 3 can see person 4.
Person 4 can see person 5.
Person 5 can see no one since nobody is to the right of them.

```

 **Example 2:** 

```
Input: heights = [5,1,2,3,10]
Output: [4,1,1,1,0]

```

 

 **Constraints:** 

- n == heights.length
- 1 <= n <= 105
- 1 <= heights[i] <= 105
- All the values of heights are unique.

## Solution

**Language:** Java  
**Runtime:** 55 ms (beats 24.32%)  
**Memory:** 116.1 MB (beats 74.80%)  
**Submitted:** 2026-10-15T10:19:36.777Z  

```java
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int n=heights.length;
        if(n==1) return new int[]{0};
        int ans[]=new int[n];
        ans[n-1]=0;
        s.push(n-1);
        ans[n-2]=1;
        if(heights[s.peek()]<heights[n-2]){
            s.pop();
        }
        s.push(n-2);
        int popC;
        for(int i=n-3;i>=0;i--){
           popC=0;
           while(!s.isEmpty() && heights[s.peek()]<heights[i]){
            s.pop();
            popC++;
           }
           
          ans[i] = popC + (s.isEmpty() ? 0 : 1);
           s.push(i);
        }

        return ans;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-visible-people-in-a-queue/)