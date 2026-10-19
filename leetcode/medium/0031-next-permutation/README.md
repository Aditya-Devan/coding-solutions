# Next Permutation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A  **permutation**  of an array of integers is an arrangement of its members into a sequence or linear order.

- For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The  **next permutation**  of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the  **next permutation**  of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

- For example, the next permutation of arr = [1,2,3] is [1,3,2].
- Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
- While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers `nums`,  *find the next permutation of*  `nums`.

The replacement must be  **in place**  and use only constant extra memory.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: [1,3,2]

```

 **Example 2:** 

```
Input: nums = [3,2,1]
Output: [1,2,3]

```

 **Example 3:** 

```
Input: nums = [1,1,5]
Output: [1,5,1]

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 6.23%)  
**Memory:** 44.7 MB (beats 31.52%)  
**Submitted:** 2026-10-19T08:15:49.435Z  

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = breakIdx(nums);
        
        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }
        
        // Sort the suffix to make the smallest element > nums[idx] easy to find
        Arrays.sort(nums, idx + 1, len);
        
        // Find and swap with the first element greater than nums[idx]
        for (int i = idx + 1; i < len; i++) {
            if (nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp; 
                break;
            }
        }
        
        // Sort the suffix again to restore ascending order
        Arrays.sort(nums, idx + 1, len);
        return;
    }
    
    // Function to find breaking index and return it
    public int breakIdx(int[] nums) {
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/next-permutation/)