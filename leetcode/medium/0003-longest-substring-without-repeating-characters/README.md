# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 105
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Java  
**Runtime:** 68 ms (beats 28.96%)  
**Memory:** 47.8 MB (beats 54.01%)  
**Submitted:** 2026-10-26T12:01:27.140Z  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1){
            return n;
        }
        int i=0;
        int j=0;
        int maxLen=Integer.MIN_VALUE;
        Set<Character> st=new HashSet<>();
        while(j<n){
            while(!st.isEmpty() && st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            
            st.add(s.charAt(j));
             if(st.size()==j-i+1){
               maxLen=Math.max(j-i+1,maxLen);
             }

             j++;

        }
        return maxLen;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)