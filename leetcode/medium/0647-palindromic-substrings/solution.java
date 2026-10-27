class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        int ans=0;
        for(int i=0;i<len;i++){
            int cnt1=expand(s,i,i);
            int cnt2=expand(s,i,i+1);

            ans+=cnt1;
            ans+=cnt2;
        }
        return ans;
    }

     public int expand(String s, int l, int r) {
        int count=0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;

        }

        return count;
    }
}