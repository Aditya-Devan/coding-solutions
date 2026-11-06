# Zigzag Conversion

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R

```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);

```

 

 **Example 1:** 

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

```

 **Example 2:** 

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

```

 **Example 3:** 

```
Input: s = "A", numRows = 1
Output: "A"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consists of English letters (lower-case and upper-case), ',' and '.'.
- 1 <= numRows <= 1000

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 91.99%)  
**Memory:** 45.9 MB (beats 96.08%)  
**Submitted:** 2026-11-06T13:31:58.721Z  

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int increment = 2 * (numRows - 1);

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < n; i += increment) {
                res.append(s.charAt(i));
                
                // For rows other than the first and last, there is a character in between peaks
                int middleCharIndex = i + increment - 2 * r;
                if (r > 0 && r < numRows - 1 && middleCharIndex < n) {
                    res.append(s.charAt(middleCharIndex));
                }
            }
        }

        return res.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/zigzag-conversion/)