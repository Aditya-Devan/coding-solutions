# Text Justification

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

 **Note:** 

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
- The input array words contains at least one word.

 

 **Example 1:** 

```
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

 **Example 2:** 

```
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
```

 **Example 3:** 

```
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

 

 **Constraints:** 

- 1 <= words.length <= 300
- 1 <= words[i].length <= 20
- words[i] consists of only English letters and symbols.
- 1 <= maxWidth <= 100
- words[i].length <= maxWidth

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 36.61%)  
**Memory:** 42.8 MB (beats 75.67%)  
**Submitted:** 2026-11-08T13:54:48.405Z  

```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int totChars = 0;

        for (int i = 0; i < words.length; i++) {

      
            if (totChars + temp.size() + words[i].length() <= maxWidth) {
                temp.add(words[i]);
                totChars += words[i].length();
            } else {
              
                ans.add(justified(totChars, maxWidth, temp));
                temp = new ArrayList<>();
                totChars = 0;
                i--; 
            }
        }

     
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));
            if (i != temp.size() - 1) sb.append(" ");
        }

        while (sb.length() < maxWidth) sb.append(" ");
        ans.add(sb.toString());

        return ans;
    }

    public String justified(int charLen, int maxW, List<String> temp) {
        int wordCount = temp.size() - 1;

        if (wordCount == 0) {
            StringBuilder sb = new StringBuilder(temp.get(0));
            while (sb.length() < maxW) sb.append(" ");
            return sb.toString();
        }

        int reqSpaces = maxW - charLen;
        int totSpace = reqSpaces / wordCount;
        int extra = reqSpaces % wordCount;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));

            if (i < wordCount) {
                int spaces = totSpace + (i < extra ? 1 : 0);
                sb.append(" ".repeat(spaces));
            }
        }

        return sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/text-justification/)