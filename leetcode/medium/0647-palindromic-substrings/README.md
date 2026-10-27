# Palindromic Substrings

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the number of  **palindromic substrings**  in it*.

A string is a  **palindrome**  when it reads the same backward as forward.

A  **substring**  is a contiguous sequence of characters within the string.

 

 **Example 1:** 

```
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

```

 **Example 2:** 

```
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 65.11%)  
**Memory:** 42.3 MB (beats 94.70%)  
**Submitted:** 2026-10-27T08:44:42.367Z  

```java
class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        int ans=0;
        for(int i=0;i<len;i++){
            int cnt1=expand(s,i,i);
            int cnt2=expand(s,i,i+1);

            ans+=cnt1;
            ans+=cnt2;
        }
        return ans;
    }

     public int expand(String s, int l, int r) {
        int count=0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;

        }

        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-substrings/)