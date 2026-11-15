# Sort an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem  **without using any built-in**  functions in `O(nlog(n))` time complexity and with the smallest space complexity possible.

 

Original
Java
 **Example 1:** 

```
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

```

 **Example 2:** 

```
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 104
- -5  *104 <= nums[i] <= 5*  104

## Solution

**Language:** Java  
**Runtime:** 27 ms (beats 53.59%)  
**Memory:** 82.7 MB (beats 73.22%)  
**Submitted:** 2026-11-15T11:35:00.141Z  

```java

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums; 
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return; 
        }
        int mid = start + (end - start) / 2;
        //merge sort
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        // Merge the sorted halves
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[mid + 1 + i];
        }

        // Merge the two sorted halves back into the original array
        int i = 0, j = 0, k = start;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/sort-an-array/)