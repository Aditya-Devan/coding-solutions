class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int n=heights.length;
        if(n==1) return new int[]{0};
        int ans[]=new int[n];
        ans[n-1]=0;
        s.push(n-1);
        ans[n-2]=1;
        if(heights[s.peek()]<heights[n-2]){
            s.pop();
        }
        s.push(n-2);
        int popC;
        for(int i=n-3;i>=0;i--){
           popC=0;
           while(!s.isEmpty() && heights[s.peek()]<heights[i]){
            s.pop();
            popC++;
           }
           
          ans[i] = popC + (s.isEmpty() ? 0 : 1);
           s.push(i);
        }

        return ans;

    }
}