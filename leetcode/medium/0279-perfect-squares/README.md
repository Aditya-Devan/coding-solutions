# Perfect Squares

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer `n`, return  *the least number of perfect square numbers that sum to*  `n`.

A  **perfect square**  is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, `1`, `4`, `9`, and `16` are perfect squares while `3` and `11` are not.

 

 **Example 1:** 

```
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

```

 **Example 2:** 

```
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

```

 

 **Constraints:** 

- 1 <= n <= 104

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 64.48%)  
**Memory:** 44.4 MB (beats 77.35%)  
**Submitted:** 2026-08-30T04:03:21.570Z  

```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int sq = 1; sq * sq <= i; sq++) {
                int square = sq * sq;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/perfect-squares/)