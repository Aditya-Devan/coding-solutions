class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        int j=len-1;
        int ans=0;
        for(int i=0;i<len;i++){
           if(citations[i]==0) continue;
           int h=len-i;
           if(j-i+1>=h && citations[i]>=h){
               return h;
           }
        }
        return ans;
    }
}