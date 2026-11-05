class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, required = 0;
        for (int c : count) {
            if (c > 0) required++;
        }

        int formed = 0;
        int[] windowCount = new int[26];

        while (right < m) {
            char c = s2.charAt(right);
            windowCount[c - 'a']++;

            if (count[c - 'a'] > 0 && windowCount[c - 'a'] == count[c - 'a']) {
                formed++;
            }

            if (right - left + 1 > n) {
                char leftChar = s2.charAt(left);
                if (count[leftChar - 'a'] > 0 && windowCount[leftChar - 'a'] == count[leftChar - 'a']) {
                    formed--;
                }
                windowCount[leftChar - 'a']--;
                left++;
            }

            if (formed == required) return true;
            right++;
        }

        return false;
    }
}