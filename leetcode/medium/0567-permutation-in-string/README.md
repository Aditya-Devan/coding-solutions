# Permutation in String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, or `false` otherwise.

In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.

 

 **Example 1:** 

```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

```

 **Example 2:** 

```
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

```

 

 **Constraints:** 

- 1 <= s1.length, s2.length <= 104
- s1 and s2 consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 88.36%)  
**Memory:** 43.5 MB (beats 88.01%)  
**Submitted:** 2026-11-05T07:46:24.425Z  

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, required = 0;
        for (int c : count) {
            if (c > 0) required++;
        }

        int formed = 0;
        int[] windowCount = new int[26];

        while (right < m) {
            char c = s2.charAt(right);
            windowCount[c - 'a']++;

            if (count[c - 'a'] > 0 && windowCount[c - 'a'] == count[c - 'a']) {
                formed++;
            }

            if (right - left + 1 > n) {
                char leftChar = s2.charAt(left);
                if (count[leftChar - 'a'] > 0 && windowCount[leftChar - 'a'] == count[leftChar - 'a']) {
                    formed--;
                }
                windowCount[leftChar - 'a']--;
                left++;
            }

            if (formed == required) return true;
            right++;
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/permutation-in-string/)