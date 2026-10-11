# Decode String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an encoded string, return its decoded string.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, `k`. For example, there will not be input like `3a` or `2[4]`.

The test cases are generated so that the length of the output will never exceed `105`.

 

 **Example 1:** 

```
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

```

 **Example 2:** 

```
Input: s = "3[a2[c]]"
Output: "accaccacc"

```

 **Example 3:** 

```
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

```

 

 **Constraints:** 

- 1 <= s.length <= 30
- s consists of lowercase English letters, digits, and square brackets '[]'.
- s is guaranteed to be a valid input.
- All the integers in s are in the range [1, 300].

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 83.90%)  
**Memory:** 42.8 MB (beats 61.43%)  
**Submitted:** 2026-10-11T13:13:22.284Z  

```java
class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder token = new StringBuilder();
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                st.push(token.toString());
                st.push(String.valueOf(num));
                token.setLength(0);
                num = 0;
            } else if (c == ']') {
                String repeatNumStr = st.pop();
                int repeatTimes = Integer.parseInt(repeatNumStr);
                String prevString = st.pop();
                
                StringBuilder decoded = new StringBuilder(prevString);
                String currentToken = token.toString();
                for (int k = 0; k < repeatTimes; k++) {
                    decoded.append(currentToken);
                }
                token = decoded;
            } else {
                token.append(c);
            }
        }
        return token.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/decode-string/)