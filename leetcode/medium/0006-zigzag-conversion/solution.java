class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int increment = 2 * (numRows - 1);

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < n; i += increment) {
                res.append(s.charAt(i));
                
                // For rows other than the first and last, there is a character in between peaks
                int middleCharIndex = i + increment - 2 * r;
                if (r > 0 && r < numRows - 1 && middleCharIndex < n) {
                    res.append(s.charAt(middleCharIndex));
                }
            }
        }

        return res.toString();
    }
}