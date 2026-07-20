class Solution {
    public int maximumWhiteTiles(int[][] tiles, int cLen) {
        Arrays.sort(tiles,(a,b)->{
            if(a[0]!=b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        int n = tiles.length;
        int[]psum = new int[n];
        
        int val = 0;
        for(int i=0;i<n;i++)
        {
            val += (tiles[i][1] - tiles[i][0] + 1);
            psum[i] = val;
        }
        
        int max = 0;
        
        for(int i=0;i<n;i++)
        {
            int st = tiles[i][0];
            int find = st + cLen - 1;
            int idx = binarySearch(tiles,find);
            int sum = (idx-2>=0 && i-1>=0) ? psum[idx-2] - psum[i-1]: 0;
            if(idx-2>=0  && i==0)
                sum = psum[idx-2];
            if(find >= tiles[idx-1][1])
                sum+= (tiles[idx-1][1] - tiles[idx-1][0] + 1);
            else
                sum+= (find - tiles[idx-1][0] + 1);
            max = Math.max(max,sum);
        }
        return max;
    }
    
    public int binarySearch(int[][] tiles, int find)
    {
        int st = 0;
        int end = tiles.length;
        while(st<end)
        {
            int mid = st + (end - st)/2;
            if(tiles[mid][0] <= find)
                st = mid+1;
            else
                end = mid;
        }
        return st;
    }
}