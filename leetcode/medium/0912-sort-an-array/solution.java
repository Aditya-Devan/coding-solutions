
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
