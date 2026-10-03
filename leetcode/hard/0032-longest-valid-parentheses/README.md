# Longest Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string containing just the characters `'('` and `')'`, return  *the length of the longest valid (well-formed) parentheses **substring*.

 

 **Example 1:** 

```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

```

 **Example 2:** 

```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

```

 **Example 3:** 

```
Input: s = ""
Output: 0

```

 

 **Constraints:** 

- 0 <= s.length <= 3 * 104
- s[i] is '(', or ')'.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 96.14%)  
**Memory:** 44.2 MB (beats 97.31%)  
**Submitted:** 2026-10-03T05:16:25.698Z  

```java
class Solution {
    public int longestValidParentheses(String s) {
        int len=s.length();
        if(len==0) return 0;
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<len;i++){
            int lan=0;
           char ch=s.charAt(i);
           if(ch=='(') left++;
           else if(ch==')') right++;

           if(left==right){
              lan=2*left;
              max=Math.max(lan,max);
           }else if(right>left){
            right=0;
            left=0;
           }
        } 

      left=0;
      right=0;
      for(int i=len-1;i>=0;i--){
        int lan=0;
        char ch=s.charAt(i);
        if(ch=='(') left++;
          else if(ch==')') right++;

         if(left==right){
              lan=2*left;
              max=Math.max(lan,max);
         } else if(left>right){
            left=0;
            right=0;
         } 
      }

        return max;   
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)