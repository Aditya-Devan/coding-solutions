# Wiggle Sort II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, reorder it such that `nums[0] < nums[1] > nums[2] < nums[3]...`.

You may assume the input array always has a valid answer.

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.

```

 **Example 2:** 

```
Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 104
- 0 <= nums[i] <= 5000
- It is guaranteed that there will be an answer for the given input nums.

 

 **Follow Up:**  Can you do it in `O(n)` time and/or  **in-place**  with `O(1)` extra space?

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 96.40%)  
**Memory:** 48.4 MB (beats 76.51%)  
**Submitted:** 2026-11-15T12:57:13.959Z  

```java
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int arr[]=new int[len];

        int j=len-1;
        for(int i=1;i<len;i=i+2){
            arr[i]=nums[j--];
        }
        for(int i=0;i<len;i=i+2){
            arr[i]=nums[j--];
        } 

        for(int i=0;i<len;i++){
            nums[i]=arr[i];
        }

        return;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/wiggle-sort-ii/)