
class Solution {
    public long countValidSubstrings(String s) {

        int n = s.length();

        int lastA = -1;
        int latestAB = -1;
        int badStart = -1;

        long ans = 0;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            if (ch == 'a') {
                lastA = right;
            }

            else if (ch == 'b') {
                if (lastA != -1) {
                    latestAB = Math.max(latestAB, lastA);
                }
            }

            else if (ch == 'c') {
                if (latestAB != -1) {
                    badStart = Math.max(badStart, latestAB);
                }
            }

            ans += (right - badStart);
        }

        return ans;
    }
}