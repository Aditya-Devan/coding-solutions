# Minimum Moves to Equal Array Elements II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of size `n`, return  *the minimum number of moves required to make all array elements equal*.

In one move, you can increment or decrement an element of the array by `1`.

Test cases are designed so that the answer will fit in a  **32-bit**  integer.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

```

 **Example 2:** 

```
Input: nums = [1,10,2,9]
Output: 16

```

 

 **Constraints:** 

- n == nums.length
- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 33.80%)  
**Memory:** 46.5 MB (beats 96.20%)  
**Submitted:** 2026-11-02T11:31:14.148Z  

```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long[] prefix = new long[len];
        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int min = nums[0];
        int max = nums[len - 1];
        long ans = Long.MAX_VALUE;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int idx = findMaxIndex(nums, mid);
            
            long moves = 0;
            if (idx != -1) {
                // Elements from 0 to idx are <= mid
                long leftCount = idx + 1;
                long leftSum = prefix[idx];
                moves += (mid * leftCount) - leftSum;
                
                // Elements from idx + 1 to len - 1 are > mid
                long rightCount = len - 1 - idx;
                long rightSum = prefix[len - 1] - prefix[idx];
                moves += rightSum - (mid * rightCount);
            } else {
                // All elements are > mid
                long rightSum = prefix[len - 1];
                moves += rightSum - ((long) mid * len);
            }   

            ans = Math.min(ans, moves);

            // Cut the search space based on slope/counts
            // If the number of elements <= mid is less than elements > mid, 
            // we need a larger target to minimize absolute differences.
            int leftCount = (idx == -1) ? 0 : (idx + 1);
            int rightCount = len - leftCount;

            if (leftCount < rightCount) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return (int) ans;
    }

    private int findMaxIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)