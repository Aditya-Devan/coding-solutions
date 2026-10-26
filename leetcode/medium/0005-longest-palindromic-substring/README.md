# Longest Palindromic Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the longest*   *palindromic*   *substring*  in `s`.

 

 **Example 1:** 

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cbbd"
Output: "bb"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consist of only digits and English letters.

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 62.90%)  
**Memory:** 42.9 MB (beats 96.80%)  
**Submitted:** 2026-10-26T12:47:39.237Z  

```java
class Solution {

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);     
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expand(String s, int l, int r) {

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)