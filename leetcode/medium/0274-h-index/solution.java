class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        int j=len-1;
        int ans=0;
        for(int i=0;i<len;i++){
           if(citations[i]==0) continue;
           int h=citations[i];
           if(j-i+1>=h){
            ans=Math.max(ans,h);
           }
        }
        return ans;
    }
}