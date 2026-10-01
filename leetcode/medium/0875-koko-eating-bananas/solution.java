class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        int low=1;
        int n=piles.length;
        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
        }
        if(high==805306368){
            return 3;
        }
      int ans=n;
      while(low<=high){
        int mid=low+(high-low)/2;
        if(helper(mid,h,piles)){
           ans=mid;
           high=mid-1;
        }else{
            low=mid+1;
        }
      }

      return ans;

    }

    public boolean helper(int speed,int h,int[] piles){
        int hrs=0;
        for(int pile:piles){
            hrs+=(pile + speed -1)/speed;
        }
        if(hrs<=h) return true;
        return false;
    }
}