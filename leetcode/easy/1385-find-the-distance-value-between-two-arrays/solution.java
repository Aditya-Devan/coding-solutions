class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (!helper(arr1[i], d, arr2)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean helper(int num, int d, int[] arr2) {
        int low = num - d;
        int high = num + d;
        int start = 0;
        int end = arr2.length - 1; // Fixed: should be length - 1
        
        while (start <= end) {     // Fixed: use <= so single-element ranges are checked
            int mid = start + (end - start) / 2;
            if (arr2[mid] >= low && arr2[mid] <= high) {
                return true;
            } else if (arr2[mid] < low) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}