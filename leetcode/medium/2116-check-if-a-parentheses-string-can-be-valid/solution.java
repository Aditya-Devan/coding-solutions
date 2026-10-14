class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0) return false;
        Stack<Integer> s1=new Stack<>();//for lock
        Stack<Integer> s2=new Stack<>();//for unlock
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char lock=locked.charAt(i);
            if(ch=='('){
                if(lock=='0'){
                    s2.push(i);
                }else{
                    s1.push(i);
                }
            }else{
                if(lock=='1'){
                    if(s1.isEmpty() && s2.isEmpty()){
                        return false;
                    }
                   if(!s1.isEmpty()){
                    s1.pop();
                   }else{
                    s2.pop();
                   }
                }
                else{
                    s2.push(i);
                }
            }
        }


       while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek()<s2.peek()){
                s1.pop();
                s2.pop();
            }else return false;
        }

        if(!s1.isEmpty()) return false;
        else if(s2.size()%2!=0) return false;

        return true; 
       

    }
}