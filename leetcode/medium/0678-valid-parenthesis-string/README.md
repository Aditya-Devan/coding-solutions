# Valid Parenthesis String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` containing only three types of characters: `'('`, `')'` and `' *'`, return `true`* if *`s`* is  **valid** *.

The following rules define a  **valid**  string:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

 

 **Example 1:** 

```
Input: s = "()"
Output: true

```

 **Example 2:** 

```
Input: s = "(*)"
Output: true

```

 **Example 3:** 

```
Input: s = "(*))"
Output: true

```

 **Example 4:** 

```
Input: s = "("
Output: false

```

 

 **Constraints:** 

- 1 <= s.length <= 100
- s[i] is '(', ')' or '*'.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 26.70%)  
**Memory:** 42.6 MB (beats 67.95%)  
**Submitted:** 2026-10-04T19:27:51.963Z  

```java
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> asterisksSt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openSt.push(i);
            } else if (ch == '*') {
                asterisksSt.push(i);
            } else {
                if (!openSt.isEmpty()) {
                    openSt.pop();
                } else if (!asterisksSt.isEmpty()) {
                    asterisksSt.pop();
                } else {
                    return false;
                }
            }
        }

       
        while (!openSt.isEmpty() && !asterisksSt.isEmpty()) {
            if (openSt.peek() > asterisksSt.peek()) {
                return false;
            }
            openSt.pop();
            asterisksSt.pop();
        }

        return openSt.isEmpty();
    }
}


```

---

[View on LeetCode](https://leetcode.com/problems/valid-parenthesis-string/)