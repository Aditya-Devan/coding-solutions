class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        int left = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {

            // Check whether "abc" ends at current index
            if (right >= 2 &&
                s.charAt(right - 2) == 'a' &&
                s.charAt(right - 1) == 'b' &&
                s.charAt(right) == 'c') {

                left = Math.max(left, right - 1);
            }

            // Count valid substrings ending at right
            ans += (right - left + 1);
        }

        return ans;
    }
}