# Maximum Product of Two Digits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a positive integer `n`.

Return the  **maximum**  product of any two digits in `n`.

 **Note:**  You may use the  **same**  digit twice if it appears more than once in `n`.

 

 **Example 1:** 

 **Input:**  n = 31

 **Output:**  3

 **Explanation:** 

- The digits of n are [3, 1].
- The possible products of any two digits are: 3 * 1 = 3.
- The maximum product is 3.

 **Example 2:** 

 **Input:**  n = 22

 **Output:**  4

 **Explanation:** 

- The digits of n are [2, 2].
- The possible products of any two digits are: 2 * 2 = 4.
- The maximum product is 4.

 **Example 3:** 

 **Input:**  n = 124

 **Output:**  8

 **Explanation:** 

- The digits of n are [1, 2, 4].
- The possible products of any two digits are: 1  *2 = 2, 1*  4 = 4, 2 * 4 = 8.
- The maximum product is 8.

 

 **Constraints:** 

- 10 <= n <= 109

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 42.5 MB (beats 74.48%)  
**Submitted:** 2026-07-25T10:40:03.731Z  

```java
class Solution {

    public int maxProduct(int n) {
        int first = 0,
            second = 0;
        while (n > 0) {
            int x = n % 10;
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
            n /= 10;
        }
        return first * second;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-product-of-two-digits/)