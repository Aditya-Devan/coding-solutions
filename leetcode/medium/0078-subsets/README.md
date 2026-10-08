# Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of  **unique**  elements, return  *all possible*   *subsets*   *(the power set)*.

The solution set  **must not**  contain duplicate subsets. Return the solution in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [[],[0]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- All the numbers of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 87.51%)  
**Memory:** 44.4 MB (beats 7.27%)  
**Submitted:** 2026-10-08T11:35:40.534Z  

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lis=new ArrayList<>();
        dfs(0,ans,lis,nums);
        return ans;
    }

    public void dfs(int idx,List<List<Integer>> ans,List<Integer> lis,int[] nums){
        int n=nums.length;
        if(idx==n){
            ans.add(new ArrayList<>(lis));
            return;
        }
        //pick it and backtrack
        lis.add(nums[idx]);
        dfs(idx+1,ans,lis,nums);
        lis.remove(lis.size()-1);
        //do not pick it
        dfs(idx+1,ans,lis,nums);
        return;

    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/subsets/)