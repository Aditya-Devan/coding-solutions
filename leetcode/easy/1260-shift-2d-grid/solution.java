class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r=grid.length;
        int c=grid[0].length;
        int[] nums=new int[r*c];
        int ptr=0;
        for(int[] ar:grid){
          for(int i:ar){
            nums[ptr++]=i;
          }
        }
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
         ptr=0;
         List<List<Integer>> ans=new ArrayList<>();
         for(int i=0;i<r;i++){
             List<Integer> lis=new ArrayList<>();
            for(int j=0;j<c;j++){
               lis.add(nums[ptr++]);
            }
            ans.add(lis);
         }
     return ans;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}