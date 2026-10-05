class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> st=new Stack<>();

       int score=0;
       int len=s.length();
       for(int i=0;i<len;i++){
        char ch=s.charAt(i);
        if(ch=='('){
            st.push(score);
            score=0;
        }else{
            if(s.charAt(i-1)=='('){
                score=st.peek()+1;
            }else{
                score=st.peek() + (2*score);

            }
            st.pop();
        }
       }

       return score;
    }
}      