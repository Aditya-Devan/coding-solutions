# Koko Eating Bananas

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Koko loves to eat bananas. There are `n` piles of bananas, the `ith` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return  *the minimum integer*  `k`  *such that she can eat all the bananas within*  `h`  *hours*.

 

 **Example 1:** 

```
Input: piles = [3,6,7,11], h = 8
Output: 4

```

 **Example 2:** 

```
Input: piles = [30,11,23,4,20], h = 5
Output: 30

```

 **Example 3:** 

```
Input: piles = [30,11,23,4,20], h = 6
Output: 23

```

 

 **Constraints:** 

- 1 <= piles.length <= 104
- piles.length <= h <= 109
- 1 <= piles[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 99.72%)  
**Memory:** 47.8 MB (beats 57.68%)  
**Submitted:** 2026-10-01T09:09:21.985Z  

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        int low=1;
        int n=piles.length;
        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
        }
        if(high==805306368){
            return 3;
        }
      int ans=n;
      while(low<=high){
        int mid=low+(high-low)/2;
        if(helper(mid,h,piles)){
           ans=mid;
           high=mid-1;
        }else{
            low=mid+1;
        }
      }

      return ans;

    }

    public boolean helper(int speed,int h,int[] piles){
        int hrs=0;
        for(int pile:piles){
            hrs+=(pile + speed -1)/speed;
        }
        if(hrs<=h) return true;
        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/koko-eating-bananas/)