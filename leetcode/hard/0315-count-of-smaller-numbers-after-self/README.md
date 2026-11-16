# Count of Smaller Numbers After Self

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums`, return *an integer array* `counts` *where* `counts[i]` *is the number of smaller elements to the right of* `nums[i]`.

 

Original
Java
 **Example 1:** 

```
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

```

 **Example 2:** 

```
Input: nums = [-1]
Output: [0]

```

 **Example 3:** 

```
Input: nums = [-1,-1]
Output: [0,0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 50 ms (beats 77.40%)  
**Memory:** 88.4 MB (beats 94.88%)  
**Submitted:** 2026-11-16T18:04:58.818Z  

```java
class Solution {

    public void mergeSort(int[] nums, int[] temp, int[] indexes, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, indexes, start, mid);
        mergeSort(nums, temp, indexes, mid + 1, end);

        merge(nums, temp, indexes, start, mid, end);
    }

  
     public void merge(int[] nums, int[] counts, int[] indexes, int start, int mid, int end) {

    int left = start;
    int right = mid + 1;

    int smallerFromRight = 0;

    int[] merged = new int[end - start + 1];
    int pos = 0;

    while (left <= mid && right <= end) {

        if (nums[indexes[right]] < nums[indexes[left]]) {

            merged[pos++] = indexes[right++];
            smallerFromRight++;

        } else {

            counts[indexes[left]] += smallerFromRight;
            merged[pos++] = indexes[left++];
        }
    }

    while (left <= mid) {

        counts[indexes[left]] += smallerFromRight;
        merged[pos++] = indexes[left++];
    }

    while (right <= end) {

        merged[pos++] = indexes[right++];
    }

    for (int x = 0; x < merged.length; x++) {
        indexes[start + x] = merged[x];
    }
}


    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];     
        int[] indexes = new int[n];   
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, temp, indexes, 0, n - 1);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : temp) {
            ans.add(val);
        }
        return ans;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)