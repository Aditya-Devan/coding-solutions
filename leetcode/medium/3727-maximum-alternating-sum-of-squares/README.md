# Maximum Alternating Sum of Squares

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`. You may  **rearrange the elements**  in any order.

The  **alternating score**  of an array `arr` is defined as:

- score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 +...

Return an integer denoting the  **maximum possible alternating score**  of `nums` after rearranging its elements.

 

 **Example 1:** 

 **Input:**  nums = [1,2,3]

 **Output:**  12

 **Explanation:** 

A possible rearrangement for `nums` is `[2,1,3]`, which gives the maximum alternating score among all possible rearrangements.

The alternating score is calculated as:

`score = 22 - 12 + 32 = 4 - 1 + 9 = 12`

 **Example 2:** 

 **Input:**  nums = [1,-1,2,-2,3,-3]

 **Output:**  16

 **Explanation:** 

A possible rearrangement for `nums` is `[-3,-1,-2,1,3,2]`, which gives the maximum alternating score among all possible rearrangements.

The alternating score is calculated as:

`score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16`

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -4  *104 <= nums[i] <= 4*  104

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 68.31%)  
**Memory:** 132.3 MB (beats 61.27%)  
**Submitted:** 2026-10-13T07:05:35.322Z  

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        
        int mid = n / 2;
        long sub = 0;
        long add = 0;
        
       
        for (int i = 0; i < n; i++) {
            long sq = (long) nums[i] * nums[i]; 
            if (i < mid) {
                sub += sq;
            } else {
                add += sq;
            }
        }
        
        return add - sub;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-alternating-sum-of-squares/)