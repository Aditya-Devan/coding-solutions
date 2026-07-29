# Smallest Range Covering Elements from K Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You have `k` lists of sorted integers in  **non-decreasing order**. Find the  **smallest**  range that includes at least one number from each of the `k` lists.

We define the range `[a, b]` is smaller than range `[c, d]` if `b - a < d - c`  **or**  `a < c` if `b - a == d - c`.

 

 **Example 1:** 

```
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

```

 **Example 2:** 

```
Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]

```

 

 **Constraints:** 

- nums.length == k
- 1 <= k <= 3500
- 1 <= nums[i].length <= 50
- -105 <= nums[i][j] <= 105
- nums[i] is sorted in non-decreasing order.

## Solution

**Language:** Java  
**Runtime:** 96 ms (beats 69.26%)  
**Memory:** 85.6 MB (beats 68.90%)  
**Submitted:** 2026-07-29T16:10:05.322Z  

```java
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val); 
        }

        int[] bestRange = new int[]{-100000, 100000}; 

        while (minHeap.size() == nums.size()) { 
            int[] curr = minHeap.poll();
            int minVal = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];

            if (currentMax - minVal < bestRange[1] - bestRange[0]) {
                bestRange[0] = minVal;
                bestRange[1] = currentMax;
            }

            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                currentMax = Math.max(currentMax, nextVal); 
            } else {
                break; 
            }
        }

        return bestRange;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)