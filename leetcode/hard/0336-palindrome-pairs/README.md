# Palindrome Pairs

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed**  array of  **unique**  strings `words`.

A  **palindrome pair**  is a pair of integers `(i, j)` such that:

- 0 <= i, j < words.length,
- i != j, and
- words[i] + words[j] (the concatenation of the two strings) is a palindrome.

Return  *an array of all the  **palindrome pairs**  of* `words`.

You must write an algorithm with `O(sum of words[i].length)` runtime complexity.

 

Original
Java
 **Example 1:** 

```
Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]

```

 **Example 2:** 

```
Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

```

 **Example 3:** 

```
Input: words = ["a",""]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["a","a"]

```

 

 **Constraints:** 

- 1 <= words.length <= 5000
- 0 <= words[i].length <= 300
- words[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 1368 ms (beats 30.08%)  
**Memory:** 60 MB (beats 93.49%)  
**Submitted:** 2026-11-12T13:50:39.268Z  

```java
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ans;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i == blankIdx) continue;
                if (isPalindrome(words[i])) {
                    ans.add(Arrays.asList(blankIdx, i));
                    ans.add(Arrays.asList(i, blankIdx));
                }
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();
            
            for (int j = 0; j < n; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                // If left part is a palindrome, check if reverse of right part exists in map
                if (isPalindrome(left)) {
                    String reversedRight = reverse(right);
                    if (map.containsKey(reversedRight)) {
                        int jIdx = map.get(reversedRight);
                        if (jIdx != i) {
                            ans.add(Arrays.asList(jIdx, i));
                        }
                    }
                }
                
                // If right part is a palindrome, check if reverse of left part exists in map
                // (j > 0 ensures we don't duplicate checks when j == 0)
                if (j > 0 && isPalindrome(right)) {
                    String reversedLeft = reverse(left);
                    if (map.containsKey(reversedLeft)) {
                        int jIdx = map.get(reversedLeft);
                        if (jIdx != i) {
                            ans.add(Arrays.asList(i, jIdx));
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
  
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-pairs/)