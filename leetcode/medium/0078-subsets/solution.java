class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> lis=new ArrayList<>();
        dfs(0,ans,lis,nums);
        return ans;
    }

    public void dfs(int idx,List<List<Integer>> ans,List<Integer> lis,int[] nums){
        int n=nums.length;
        if(idx==n){
            ans.add(new ArrayList<>(lis));
            return;
        }
        //pick it and backtrack
        lis.add(nums[idx]);
        dfs(idx+1,ans,lis,nums);
        lis.remove(lis.size()-1);
        //do not pick it
        dfs(idx+1,ans,lis,nums);
        return;

    }

}