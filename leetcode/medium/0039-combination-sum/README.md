# Combination Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of  **distinct**  integers `candidates` and a target integer `target`, return  *a list of all  **unique combinations**  of* `candidates` *where the chosen numbers sum to* `target` *.*  You may return the combinations in  **any order**.

The  **same**  number may be chosen from `candidates` an  **unlimited number of times**. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to `target` is less than `150` combinations for the given input.

 

 **Example 1:** 

```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

```

 **Example 2:** 

```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

```

 **Example 3:** 

```
Input: candidates = [2], target = 1
Output: []

```

 

 **Constraints:** 

- 1 <= candidates.length <= 30
- 2 <= candidates[i] <= 40
- All elements of candidates are distinct.
- 1 <= target <= 40

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 93.28%)  
**Memory:** 46 MB (beats 18.22%)  
**Submitted:** 2026-10-08T10:29:33.338Z  

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        helper(0, target, ans, lis, candidates);
        return ans;
    }

    public void helper(int idx, int target, List<List<Integer>> ans, List<Integer> lis, int[] nums) {
       
        if (target == 0) {
            ans.add(new ArrayList<>(lis));
            return;
        }

        
        if (idx == nums.length) {
            return;
        }

        // Option 1: Pick the element (if target allows)
        if (nums[idx] <= target) {
            lis.add(nums[idx]);
            helper(idx, target - nums[idx], ans, lis, nums);
            lis.remove(lis.size() - 1); // Backtrack
        }

        // Option 2: Skip the element
        helper(idx + 1, target, ans, lis, nums);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/combination-sum/)