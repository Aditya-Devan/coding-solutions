class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = breakIdx(nums);
        
        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }
        
        // Sort the suffix to make the smallest element > nums[idx] easy to find
        Arrays.sort(nums, idx + 1, len);
        
        // Find and swap with the first element greater than nums[idx]
        for (int i = idx + 1; i < len; i++) {
            if (nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp; 
                break;
            }
        }
        
        // Sort the suffix again to restore ascending order
        Arrays.sort(nums, idx + 1, len);
        return;
    }
    
    // Function to find breaking index and return it
    public int breakIdx(int[] nums) {
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}