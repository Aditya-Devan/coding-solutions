# Largest Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Original
Java
 **Example 1:** 

```
Input: nums = [10,2]
Output: "210"

```

 **Example 2:** 

```
Input: nums = [3,30,34,5,9]
Output: "9534330"

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 95.41%)  
**Memory:** 44.6 MB (beats 66.20%)  
**Submitted:** 2026-11-15T11:02:06.898Z  

```java
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) { // Traditional for loop
            sb.append(s[i]);
        }
        
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/largest-number/)