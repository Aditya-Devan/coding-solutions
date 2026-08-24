class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int len=arr.length;
        for(int i=0;i<len;i++){
            map.put(arr[i],i);
        }
       int ans=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int subseq=solve(j,i,map,arr);
                if(subseq>=3){
                  ans=Math.max(ans,subseq);
                }
            }
        }

     return ans;
  
    }


    public int solve(int k,int j ,HashMap<Integer,Integer> map, int[] arr){
        int target=arr[k]-arr[j];
        if(map.containsKey(target) && map.get(target)<j){
            int i=map.get(target);
            return solve(j,i,map,arr) +1;
        }
        return 2;
    }
}