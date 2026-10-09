class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        dfs(0,0,"",n,ans);
        return ans;
    }

    public void dfs(int op,int cp, String s,int n,List<String> ans){
      if( op==cp &&(op+cp)==2*n){
         ans.add(s);
         return;
      }
   
      if(op<n){
        dfs(op+1,cp,s+"(",n,ans);
      }

     if(cp<op){
        dfs(op,cp+1,s+")",n,ans);
     }

     return;

    }

}