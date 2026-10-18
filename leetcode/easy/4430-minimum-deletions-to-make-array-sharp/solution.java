class Solution {
    public int minDeletions(int[] nums) {
        int len=nums.length;
        int ans=0;
        //ArrayList<Integer> al=new ArrayList<>();
        int prev=0;
        for(int i=1;i<len;i++){
            int num1=nums[i-1];
            int num2=nums[i];
            if(num1==num2){
                ans++;
            }
        }
        return ans;
    }
}