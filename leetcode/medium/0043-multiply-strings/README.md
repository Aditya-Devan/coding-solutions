# Multiply Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

 **Note:**  You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

 **Example 1:** 

```
Input: num1 = "2", num2 = "3"
Output: "6"

```

 **Example 2:** 

```
Input: num1 = "123", num2 = "456"
Output: "56088"

```

 

 **Constraints:** 

- 1 <= num1.length, num2.length <= 200
- num1 and num2 consist of digits only.
- Both num1 and num2 do not contain any leading zero, except the number 0 itself.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 82.96%)  
**Memory:** 42.6 MB (beats 99.19%)  
**Submitted:** 2026-11-05T14:33:14.750Z  

```java
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                
                // Multiply digits and add to existing value at the correct position
                int sum = n1 * n2 + arr[i + j + 1];
                
                // Store the single digit remainder
                arr[i + j + 1] = sum % 10;
                
                // Add the carry to the next higher position
                arr[i + j] += sum / 10;
            }
        }

        // Build the result string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            // Skip leading zeros unless the array is all zeros
            if (!(sb.length() == 0 && val == 0)) {
                sb.append(val);
            }
        }

        // If the result string is empty, it means the product is 0
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/multiply-strings/)