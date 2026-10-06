class Solution {
    public int minAddToMakeValid(String s) {
       int count=0;
       Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }else{
                if(!st.isEmpty() && st.peek()!=ch){
                  st.pop();  
                }else{
                    count++;
                }
            }
        }
        count+=st.size();
        return count;
    }
}