class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        int n=digits.length();
        List<String> ans=new ArrayList<>();
        char[] arr=new char[n];
        dfs(digits,0,arr,keypad,ans);
        return ans;
    }

    public void dfs(String digits,int idx,char[] arr,String[] keypad,List<String> ans){
       int n=digits.length();
       if(idx==n){
        String comb=String.valueOf(arr);
        ans.add(comb);
        return;
       }

        int digit = digits.charAt(idx)-'0';
        String characters = keypad[digit];
        int len=characters.length();
        for(int i=0;i<len;i++){
            //putting a char
            arr[idx]=characters.charAt(i);
            dfs(digits,idx+1,arr,keypad,ans);
            //asthere are array no need backtrack we can simple overwrite
        }
       return;

    }

}