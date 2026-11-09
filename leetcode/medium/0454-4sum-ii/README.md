# 4Sum II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` all of length `n`, return the number of tuples `(i, j, k, l)` such that:

- 0 <= i, j, k, l < n
- nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

 

 **Example 1:** 

```
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

```

 **Example 2:** 

```
Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1

```

 

 **Constraints:** 

- n == nums1.length
- n == nums2.length
- n == nums3.length
- n == nums4.length
- 1 <= n <= 200
- -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228

## Solution

**Language:** Java  
**Runtime:** 112 ms (beats 55.73%)  
**Memory:** 46.5 MB (beats 83.13%)  
**Submitted:** 2026-11-09T19:12:26.728Z  

```java
class Solution {
    public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int n = arr1.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map.put(arr3[i] + arr4[j], map.getOrDefault(arr3[i] + arr4[j], 0)+1);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count += map.getOrDefault(- (arr1[i] + arr2[j]), 0);
            }
        }
        return count;
}
}
```

---

[View on LeetCode](https://leetcode.com/problems/4sum-ii/)