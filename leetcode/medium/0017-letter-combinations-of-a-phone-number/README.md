# Letter Combinations of a Phone Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in  **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

 **Example 1:** 

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```

 **Example 2:** 

```
Input: digits = "2"
Output: ["a","b","c"]

```

 

 **Constraints:** 

- 1 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.8 MB (beats 99.31%)  
**Submitted:** 2026-10-10T06:12:34.812Z  

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        int n=digits.length();
        List<String> ans=new ArrayList<>();
        char[] arr=new char[n];
        dfs(digits,0,arr,keypad,ans);
        return ans;
    }

    public void dfs(String digits,int idx,char[] arr,String[] keypad,List<String> ans){
       int n=digits.length();
       if(idx==n){
        String comb=String.valueOf(arr);
        ans.add(comb);
        return;
       }

        int digit = digits.charAt(idx)-'0';
        String characters = keypad[digit];
        int len=characters.length();
        for(int i=0;i<len;i++){
            //putting a char
            arr[idx]=characters.charAt(i);
            dfs(digits,idx+1,arr,keypad,ans);
            //asthere are array no need backtrack we can simple overwrite
        }
       return;

    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)