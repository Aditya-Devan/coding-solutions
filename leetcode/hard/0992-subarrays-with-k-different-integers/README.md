# Subarrays with K Different Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and an integer `k`, return  *the number of  **good subarrays**  of* `nums`.

A  **good array**  is an array where the number of different integers in that array is exactly `k`.

- For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.

A  **subarray**  is a  **contiguous**  part of an array.

 

 **Example 1:** 

```
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

```

 **Example 2:** 

```
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- 1 <= nums[i], k <= nums.length

## Solution

**Language:** Java  
**Runtime:** 52 ms (beats 18.06%)  
**Memory:** 49.9 MB (beats 68.85%)  
**Submitted:** 2026-10-21T03:30:47.488Z  

```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums, k) - subArray(nums, k - 1);
    }

    private int subArray(int[] nums, int k) {
      int count = 0, left = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int right = 0; right < nums.length;) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
            while (frequency.size() > k) {
                frequency.put(nums[left], frequency.get(nums[left]) - 1);
                if (frequency.get(nums[left]) == 0) {
                    frequency.remove(nums[left]);
                }
                left++;

            }
            count += right - left + 1;
            right++;
        }
        return count;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarrays-with-k-different-integers/)