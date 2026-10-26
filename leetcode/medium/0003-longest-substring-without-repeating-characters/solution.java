class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1){
            return n;
        }
        int i=0;
        int j=0;
        int maxLen=Integer.MIN_VALUE;
        Set<Character> st=new HashSet<>();
        while(j<n){
            while(!st.isEmpty() && st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            
            st.add(s.charAt(j));
             if(st.size()==j-i+1){
               maxLen=Math.max(j-i+1,maxLen);
             }

             j++;

        }
        return maxLen;
    }
}