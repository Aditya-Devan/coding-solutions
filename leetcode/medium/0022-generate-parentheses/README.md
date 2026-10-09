# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 65.40%)  
**Memory:** 44.8 MB (beats 44.28%)  
**Submitted:** 2026-10-09T10:04:42.417Z  

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        dfs(0,0,"",n,ans);
        return ans;
    }

    public void dfs(int op,int cp, String s,int n,List<String> ans){
      if( op==cp &&(op+cp)==2*n){
         ans.add(s);
         return;
      }
   
      if(op<n){
        dfs(op+1,cp,s+"(",n,ans);
      }

     if(cp<op){
        dfs(op,cp+1,s+")",n,ans);
     }

     return;

    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)