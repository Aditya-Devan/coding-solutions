# Group Anagrams

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of strings `strs`, group the anagrams together. You can return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  strs = ["eat","tea","tan","ate","nat","bat"]

 **Output:**  [["bat"],["nat","tan"],["ate","eat","tea"]]

 **Explanation:** 

- There is no string in strs that can be rearranged to form "bat".
- The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
- The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

 **Example 2:** 

 **Input:**  strs = [""]

 **Output:**  [[""]]

 **Example 3:** 

 **Input:**  strs = ["a"]

 **Output:**  [["a"]]

 

 **Constraints:** 

- 1 <= strs.length <= 104
- 0 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 19 ms (beats 18.18%)  
**Memory:** 50.4 MB (beats 13.05%)  
**Submitted:** 2026-11-08T14:26:22.849Z  

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len=strs.length;

        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<len;i++){
           String word=strs[i];
           int[] arr=new int[26];
             int wordLen=word.length();
             for(int j=0;j<wordLen;j++){
                char ch=word.charAt(j);
                arr[ch-'a']++;
             }
          String array = Arrays.toString(arr);
          if(!map.containsKey(array)){
            List<String> anagrams=new ArrayList<>();
            anagrams.add(word);
            map.put(array,anagrams);
          }
          else{
            map.get(array).add(word);
          }

        }

       return new ArrayList<>(map.values());

    }
}


/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> mp=new HashMap<>();
        for(String s:strs){
            int[] count=new int[26];
            for(char ch:s.toCharArray()){
               count[ch-'a']++; 
            }
            String key=Arrays.toString(count);
              if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
              }
              mp.get(key).add(s);
        }
         return new ArrayList<>(mp.values());
    }
}*/
```

---

[View on LeetCode](https://leetcode.com/problems/group-anagrams/)