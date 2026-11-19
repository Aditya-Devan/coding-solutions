class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int freq[] = new int[1001];
        for(int i=0; i<n; i++) {
            freq[citations[i]]++;
        }

        int ans = 0;
        int count = 0;
        for(int i=1000; i>=0; i--) {
            count += freq[i];
            if(count >= i) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}