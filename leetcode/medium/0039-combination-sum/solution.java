class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        helper(0, target, ans, lis, candidates);
        return ans;
    }

    public void helper(int idx, int target, List<List<Integer>> ans, List<Integer> lis, int[] nums) {
       
        if (target == 0) {
            ans.add(new ArrayList<>(lis));
            return;
        }

        
        if (idx == nums.length) {
            return;
        }

        // Option 1: Pick the element (if target allows)
        if (nums[idx] <= target) {
            lis.add(nums[idx]);
            helper(idx, target - nums[idx], ans, lis, nums);
            lis.remove(lis.size() - 1); // Backtrack
        }

        // Option 2: Skip the element
        helper(idx + 1, target, ans, lis, nums);
    }
}