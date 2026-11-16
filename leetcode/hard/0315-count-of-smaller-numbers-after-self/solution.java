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
