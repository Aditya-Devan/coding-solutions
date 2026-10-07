# Remove Invalid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s` that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return  *a list of  **unique strings**  that are valid with the minimum number of removals*. You may return the answer in  **any order**.

 

 **Example 1:** 

```
Input: s = "()())()"
Output: ["(())()","()()()"]

```

 **Example 2:** 

```
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

```

 **Example 3:** 

```
Input: s = ")("
Output: [""]

```

 

 **Constraints:** 

- 1 <= s.length <= 25
- s consists of lowercase English letters and parentheses '(' and ')'.
- There will be at most 20 parentheses in s.

## Solution

**Language:** Java  
**Runtime:** 51 ms (beats 68.32%)  
**Memory:** 47.6 MB (beats 44.81%)  
**Submitted:** 2026-10-07T19:09:20.868Z  

```java


class Solution {

    public void solve(String s, List<String> ans, Set<String> visited, int removals) {
        
        if (visited.contains(s)) {
            return;
        }

        visited.add(s);

        if (removals == 0) {
            // Check if valid answer
            if (findRemovals(s) == 0) {
                ans.add(s);
            }
            return;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isLetter(s.charAt(i))) { // Skip non-parenthesis characters
                String leftPart = s.substring(0, i);
                String rightPart = s.substring(i + 1);
                String joined = leftPart + rightPart;
                solve(joined, ans, visited, removals - 1);
            }
        }
    }

    public int findRemovals(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }

    public List<String> removeInvalidParentheses(String s) {
        int minRemovals = findRemovals(s);
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        solve(s, ans, visited, minRemovals);
        return ans;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)