# Minimum Insertions to Balance a Parentheses String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a parentheses string `s` containing only the characters `'('` and `')'`. A parentheses string is  **balanced**  if:

- Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
- Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.

In other words, we treat `'('` as an opening parenthesis and `'))'` as a closing parenthesis.

- For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters `'('` and `')'` at any position of the string to balance it if needed.

Return  *the minimum number of insertions*  needed to make `s` balanced.

 

 **Example 1:** 

```
Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.

```

 **Example 2:** 

```
Input: s = "())"
Output: 0
Explanation: The string is already balanced.

```

 **Example 3:** 

```
Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of '(' and ')' only.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 87.26%)  
**Memory:** 47.3 MB (beats 85.88%)  
**Submitted:** 2026-10-09T07:59:59.655Z  

```java
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; 
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                // We encountered a closing parenthesis ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    // Check if it forms a pair "))"
                    i++; // Skip the next ')' as it's part of the pair
                } else {
                    // Single ')' found, insert one ')' to make it "))"
                    insertions++;
                }

                if (openCount > 0) {
                    // Match with an existing '('
                    openCount--;
                } else {
                    // No '(' available, insert one '('
                    insertions++;
                }
            }
        }

        // Each unmatched '(' requires two ')'s
        insertions += openCount * 2;

        return insertions;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)