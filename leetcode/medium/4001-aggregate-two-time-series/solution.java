class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = series1.length;
        int m = series2.length;

        int i = 0, j = 0;

        while (i < n && j < m) {
            int t1 = series1[i][0];
            int t2 = series2[j][0];

            List<Integer> curr = new ArrayList<>(2);

            if (t1 == t2) {
                curr.add(t1);
                curr.add(series1[i][1] + series2[j][1]);
                i++;
                j++;
            } else if (t1 < t2) {
                curr.add(t1);
                curr.add(series1[i][1] + series2[j][1]);
                i++;
            } else {
                curr.add(t2);
                curr.add(series1[i][1] + series2[j][1]);
                j++;
            }

            ans.add(curr);
        }

        while (i < n) {
            List<Integer> curr = new ArrayList<>(2);
            curr.add(series1[i][0]);
            curr.add(series1[i][1]);
            ans.add(curr);
            i++;
        }

        while (j < m) {
            List<Integer> curr = new ArrayList<>(2);
            curr.add(series2[j][0]);
            curr.add(series2[j][1]);
            ans.add(curr);
            j++;
        }

        return ans;
    }
}