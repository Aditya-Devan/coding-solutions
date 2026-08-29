# Partition Array into Disjoint Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, partition it into two (contiguous) subarrays `left` and `right` so that:

- Every element in left is less than or equal to every element in right.
- left and right are non-empty.
- left has the smallest possible size.

Return  *the length of* `left` *after such a partitioning*.

Test cases are generated such that partitioning exists.

 

 **Example 1:** 

```
Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

```

 **Example 2:** 

```
Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- 0 <= nums[i] <= 106
- There is at least one valid answer for the given input.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-29T05:47:14.364Z  

```java
class Solution {
    public int partitionDisjoint(int[] nums) {
        int len=nums.length;
        int currmax=nums[0];
        int posmax=nums[0];
        int ans=1;
        for(int i=1;i<len;i++){
            if(nums[i]<currmax){
            ans=i+1;
            currmax=posmax;
            }else{
               posmax=Math.max(posmax,nums[i]);  
            }
            

    }

    return ans;

}
}
```

---

[View on LeetCode](https://leetcode.com/problems/partition-array-into-disjoint-intervals/)