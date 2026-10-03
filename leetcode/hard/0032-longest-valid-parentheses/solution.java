class Solution {
    public int longestValidParentheses(String s) {
        int len=s.length();
        if(len==0) return 0;
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<len;i++){
            int lan=0;
           char ch=s.charAt(i);
           if(ch=='(') left++;
           else if(ch==')') right++;

           if(left==right){
              lan=2*left;
              max=Math.max(lan,max);
           }else if(right>left){
            right=0;
            left=0;
           }
        } 

      left=0;
      right=0;
      for(int i=len-1;i>=0;i--){
        int lan=0;
        char ch=s.charAt(i);
        if(ch=='(') left++;
          else if(ch==')') right++;

         if(left==right){
              lan=2*left;
              max=Math.max(lan,max);
         } else if(left>right){
            left=0;
            right=0;
         } 
      }

        return max;   
    }
}