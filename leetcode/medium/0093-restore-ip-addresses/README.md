# Restore IP Addresses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A  **valid IP address**  consists of exactly four integers separated by single dots. Each integer is between `0` and `255` (**inclusive**) and cannot have leading zeros.

- For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.

Given a string `s` containing only digits, return  *all possible valid IP addresses that can be formed by inserting dots into* `s`. You are  **not**  allowed to reorder or remove any digits in `s`. You may return the valid IP addresses in  **any**  order.

 

 **Example 1:** 

```
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

```

 **Example 2:** 

```
Input: s = "0000"
Output: ["0.0.0.0"]

```

 **Example 3:** 

```
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

```

 

 **Constraints:** 

- 1 <= s.length <= 20
- s consists of digits only.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.90%)  
**Memory:** 43.1 MB (beats 98.23%)  
**Submitted:** 2026-10-27T08:02:52.067Z  

```java
class Solution {
    private boolean valid(String s, int start, int length) {
        return (
            length == 1 ||
            (s.charAt(start) != '0' &&
                (length < 3 ||
                    s.substring(start, start + length).compareTo("255") <= 0))
        );
    }

    private void helper(
        String s,
        int startIndex,
        List<Integer> dots,
        List<String> ans
    ) {
        final int remainingLength = s.length() - startIndex;
        final int remainingNumberOfIntegers = 4 - dots.size();
        if (
            remainingLength > remainingNumberOfIntegers * 3 ||
            remainingLength < remainingNumberOfIntegers
        ) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }
        for (
            int curPos = 1;
            curPos <= 3 && curPos <= remainingLength;
            ++curPos
        ) {
           
            dots.add(curPos);
            if (valid(s, startIndex, curPos)) {
                helper(s, startIndex + curPos, dots, ans);
            }
            dots.remove(dots.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/restore-ip-addresses/)