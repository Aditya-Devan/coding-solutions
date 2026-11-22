# Minimum Operations to Make Mountain Array I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` of length `n`.

In one operation, you may  **increment**  or  **decrement**  any element of `nums` by 1.

All elements of `nums` must remain  **positive**  (**at least**  1) after every operation.

An array is called a  **mountain array**  if there exists an index `peak` such that `0 < peak < n - 1` and:

- nums[0] < nums[1] <... < nums[peak]
- nums[peak] > nums[peak + 1] >... > nums[n - 1]

Return the  **minimum**  number of operations required to transform `nums` into a mountain array. If it is impossible, return -1.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [2,2,3]

 **Output:**  2

 **Explanation:** 

​​​​​​​One optimal way is to:

- Increment nums[1] by 1 and decrement nums[2] by 1.
- The resulting array is [2, 3, 2], which is a mountain array with peak = 1.
- Therefore, the total number of operations is 1 + 1 = 2.

 **Example 2:** 

 **Input:**  nums = [9,4,9]

 **Output:**  6

 **Explanation:** 

One optimal way is to:

- Increment nums[1] by 1 six times.
- The resulting array is [9, 10, 9], which is a mountain array with peak = 1.
- Therefore, the total number of operations is 6.

 **Example 3:** 

 **Input:**  nums = [5,7,7,4]

 **Output:**  1

 **Explanation:** 

One optimal way is to:

- Decrement nums[1] by 1.
- The resulting array is [5, 6, 7, 4], which is a mountain array with peak = 2.
- Therefore, the total number of operations is 1.

 **Example 4:** 

 **Input:**  nums = [1,2]

 **Output:**  -1

 **Explanation:** 

A mountain array must have a peak with at least one element on each side. Since `n = 2` and operations do not change the array's length, forming a mountain array is impossible.

 

 **Constraints:** 

- 1 <= n == nums.length <= 1000
- 1 <= nums[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 398 ms  
**Memory:** 211.8 MB (beats 33.33%)  
**Submitted:** 2026-11-22T14:16:33.157Z  

```java

class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        if (n < 3) return -1;

        int V = 2000;
        int INF = 1_000_000_000;

        // Left DP:
        // Minimum cost to make [0...i] strictly increasing,
        // with nums[i] = j.

        int[][] dpl = new int[n][V + 1];

        for (int[] row : dpl) {
            java.util.Arrays.fill(row, INF);
        }

        // Base case
        for (int j = 1; j <= V; j++) {
            dpl[0][j] = Math.abs(nums[0] - j);
        }

        // Build Left DP using running minimum
        for (int i = 1; i < n; i++) {

            int minCost = INF;

            for (int j = 1; j <= V; j++) {

                dpl[i][j] = minCost + Math.abs(nums[i] - j);

                minCost = Math.min(minCost, dpl[i - 1][j]);
            }
        }

        // Right DP:
        // Minimum cost to make [i...n-1] strictly decreasing,
        // with nums[i] = j.

        int[][] dpr = new int[n][V + 1];

        for (int[] row : dpr) {
            java.util.Arrays.fill(row, INF);
        }

        // Base case
        for (int j = 1; j <= V; j++) {
            dpr[n - 1][j] = Math.abs(nums[n - 1] - j);
        }

        // Build Right DP using running minimum
        for (int i = n - 2; i >= 0; i--) {

            int minCost = INF;

            for (int j = 1; j <= V; j++) {

                dpr[i][j] = minCost + Math.abs(nums[i] - j);

                minCost = Math.min(minCost, dpr[i + 1][j]);
            }
        }

        // Combine Left DP + Peak + Right DP

        int answer = INF;

        for (int i = 1; i <= n - 2; i++) {

            int leftMin = INF;
            int rightMin = INF;

            for (int j = 1; j <= V; j++) {

                // Minimum left/right cost for values k < j
                leftMin = Math.min(leftMin, dpl[i - 1][j - 1]);
                rightMin = Math.min(rightMin, dpr[i + 1][j - 1]);

                int peakCost = Math.abs(nums[i] - j);

                int totalCost = leftMin + peakCost + rightMin;

                answer = Math.min(answer, totalCost);
            }
        }

        return answer >= INF ? -1 : answer;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-mountain-array-i/)