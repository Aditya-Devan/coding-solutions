class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n=rain.length;
        String[] ans=new String[n];
        int ac=0;
        int bc=0;
        for(int i=0;i<n;i++){
            if(rain[i]==0){
                ans[i]="None";
                continue;
            } 
            boolean aliceNeeds=false;
            boolean bobNeeds=true;
            if(i<n-1 && rain[i]==1 && rain[i+1]==1){
                aliceNeeds=true;
            }
            if( aliceNeeds && (ac<bc || ac==bc)){
                ans[i]="Alice";
                ac++;
            } 
            else {
                ans[i]="Bob";
                bc++;
            }
        }
        return ans;
    }
}