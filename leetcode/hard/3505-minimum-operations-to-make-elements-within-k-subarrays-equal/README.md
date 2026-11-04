# Minimum Operations to Make Elements Within K Subarrays Equal

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and two integers, `x` and `k`. You can perform the following operation any number of times (**including zero**):

- Increase or decrease any element of nums by 1.

Return the  **minimum**  number of operations needed to have  **at least**  `k`  *non-overlapping subarrays*  of size  **exactly**  `x` in `nums`, where all elements within each subarray are equal.

 

 **Example 1:** 

 **Input:**  nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2

 **Output:**  8

 **Explanation:** 

- Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
- Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
- Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices 5 to 7) are equal. Since 8 total operations were used, 8 is the output.

 **Example 2:** 

 **Input:**  nums = [9,-2,-2,-2,1,5], x = 2, k = 2

 **Output:**  3

 **Explanation:** 

- Use 3 operations to subtract 3 from nums[4]. The resulting array is [9, -2, -2, -2, -2, 5].
- Now, all elements within each subarray [-2, -2] (from indices 1 to 2) and [-2, -2] (from indices 3 to 4) are equal. Since 3 operations were used, 3 is the output.

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -106 <= nums[i] <= 106
- 2 <= x <= nums.length
- 1 <= k <= 15
- 2 <= k * x <= nums.length

## Solution

**Language:** Java  
**Runtime:** 1171 ms (beats 7.89%)  
**Memory:** 190.6 MB (beats 52.63%)  
**Submitted:** 2026-11-04T16:27:48.130Z  

```java
class Solution {
    int n, x, k;

    long[] minOpsSubarray;
   
    long[][] memo;

    static final long INF = (long) 1e16; 
    long solve(int count, int i) {
        if (count == k)
            return 0;

        int subArraysNeeded = k - count;
        int elementsNeeded  = subArraysNeeded * x;
        int lastIndex       = i + elementsNeeded - 1;

        if (lastIndex >= n) {
            return INF;
        }

        if (memo[count][i] != -1) {
            return memo[count][i];
        }

       
        long result = minOpsSubarray[i] + solve(count + 1, i + x);

    
        result = Math.min(result, solve(count, i + 1));

        return memo[count][i] = result;
    }

  
    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int freq = map.get(val);
        if (freq == 1) map.remove(val);
        else map.put(val, freq - 1);
    }

    public long minOperations(int[] nums, int x, int k) {
        this.n = nums.length;
        this.x = x;
        this.k = k;

        minOpsSubarray = new long[n + 1];
        memo = new long[k + 1][n + 1];
        for (long[] row : memo) Arrays.fill(row, -1);

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftSize = 0, rightSize = 0;         
        long leftSum = 0, rightSum = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            if (leftSize <= rightSize) {
                add(left, nums[j]);
                leftSize++;
                leftSum += nums[j];
            } else {
                add(right, nums[j]);
                rightSize++;
                rightSum += nums[j];
            }

            // Balancing
            if (leftSize > 0 && rightSize > 0) {
                int maxLeft  = left.lastKey();
                int minRight = right.firstKey();

                if (maxLeft > minRight) {
                    remove(left, maxLeft);
                    remove(right, minRight);

                    add(left, minRight);
                    add(right, maxLeft);

                    leftSum  += minRight - maxLeft;
                    rightSum += maxLeft - minRight;
                }
            }

            // If we have found the subarray of size x
            if (j - i + 1 == x) {
                long median = left.lastKey();

                minOpsSubarray[i] = (leftSize * median - leftSum) + (rightSum - rightSize * median);

                if (left.containsKey(nums[i])) {
                    remove(left, nums[i]);
                    leftSize--;
                    leftSum -= nums[i];
                } else {
                    remove(right, nums[i]);
                    rightSize--;
                    rightSum -= nums[i];
                }
                i++;
            }

            j++;
        }

        return solve(0, 0); 
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)