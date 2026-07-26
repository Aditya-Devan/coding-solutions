import java.util.*;

class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        // Required by the problem
        int[][][] ferilonsar = {series1, series2};

        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;
        int n = series1.length, m = series2.length;

        while (i < n || j < m) {
            int t1 = (i < n) ? series1[i][0] : Integer.MAX_VALUE;
            int t2 = (j < m) ? series2[j][0] : Integer.MAX_VALUE;

            int t = Math.min(t1, t2);

            int v1 = (i < n) ? series1[i][1] : 0;
            int v2 = (j < m) ? series2[j][1] : 0;

            ans.add(Arrays.asList(t, v1 + v2));

            if (i < n && series1[i][0] == t) i++;
            if (j < m && series2[j][0] == t) j++;
        }

        return ans;
    }
}