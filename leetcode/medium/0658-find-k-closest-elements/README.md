# Find K Closest Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a  **sorted**  integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

An integer `a` is closer to `x` than an integer `b` if:

- |a - x| < |b - x|, or
- |a - x| == |b - x| and a < b

 

 **Example 1:** 

 **Input:**  arr = [1,2,3,4,5], k = 4, x = 3

 **Output:**  [1,2,3,4]

 **Example 2:** 

 **Input:**  arr = [1,1,2,3,4,5], k = 4, x = -1

 **Output:**  [1,1,2,3]

 

 **Constraints:** 

- 1 <= k <= arr.length
- 1 <= arr.length <= 104
- arr is sorted in ascending order.
- -104 <= arr[i], x <= 104

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 96.85%)  
**Memory:** 47.7 MB (beats 80.60%)  
**Submitted:** 2026-07-23T13:58:21.049Z  

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-k;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(x-arr[mid]>arr[mid+k]-x)
            {
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=low;i<low+k;i++)
        {
            ans.add(arr[i]);
        }
        return ans;
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-k-closest-elements/)