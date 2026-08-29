class Solution {
    public int partitionDisjoint(int[] nums) {
        int len=nums.length;
        int currmax=nums[0];
        int posmax=nums[0];
        int ans=1;
        for(int i=1;i<len;i++){
            if(nums[i]<currmax){
            ans=i+1;
            currmax=posmax;
            }else{
               posmax=Math.max(posmax,nums[i]);  
            }
            

    }

    return ans;

}
}