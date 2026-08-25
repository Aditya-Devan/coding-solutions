# Frog Jump

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of `stones` positions (in units) in sorted  **ascending order**, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be `1` unit.

If the frog's last jump was `k` units, its next jump must be either `k - 1`, `k`, or `k + 1` units. The frog can only jump in the forward direction.

 

 **Example 1:** 

```
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

```

 **Example 2:** 

```
Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

```

 

 **Constraints:** 

- 2 <= stones.length <= 2000
- 0 <= stones[i] <= 231 - 1
- stones[0] == 0
- stones is sorted in a strictly increasing order.

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 71.66%)  
**Memory:** 183.3 MB (beats 25.79%)  
**Submitted:** 2026-08-25T16:10:27.180Z  

```java
class Solution {
    private Boolean[][] memo;
    private Map<Integer, Integer> positionToIndexMap;

    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (stones[1] != 1) {
            return false;
        }

        positionToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positionToIndexMap.put(stones[i], i);
        }

        memo = new Boolean[n][n + 1];
        return solve(stones, 1, 1);
    }

    private boolean solve(int[] stones, int currentIndex, int lastJump) {
        if (currentIndex == stones.length - 1) {
            return true;
        }

        if (memo[currentIndex][lastJump] != null) {
            return memo[currentIndex][lastJump];
        }
        
        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
            if (nextJump <= 0) {
                continue;
            }

            int nextPosition = stones[currentIndex] + nextJump;

            if (positionToIndexMap.containsKey(nextPosition)) {
                int nextIndex = positionToIndexMap.get(nextPosition);
                if (solve(stones, nextIndex, nextJump)) {
                    return memo[currentIndex][lastJump] = true;
                }
            }
        }

        return memo[currentIndex][lastJump] = false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/frog-jump/)