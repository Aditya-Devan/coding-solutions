class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        
        int mid = n / 2;
        long sub = 0;
        long add = 0;
        
       
        for (int i = 0; i < n; i++) {
            long sq = (long) nums[i] * nums[i]; 
            if (i < mid) {
                sub += sq;
            } else {
                add += sq;
            }
        }
        
        return add - sub;
    }
}