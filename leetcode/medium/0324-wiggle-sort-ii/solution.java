class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int arr[]=new int[len];

        int j=len-1;
        for(int i=1;i<len;i=i+2){
            arr[i]=nums[j--];
        }
        for(int i=0;i<len;i=i+2){
            arr[i]=nums[j--];
        } 

        for(int i=0;i<len;i++){
            nums[i]=arr[i];
        }

        return;
    }
}