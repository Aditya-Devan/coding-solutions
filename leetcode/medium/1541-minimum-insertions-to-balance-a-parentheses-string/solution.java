class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; 
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                // We encountered a closing parenthesis ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    // Check if it forms a pair "))"
                    i++; // Skip the next ')' as it's part of the pair
                } else {
                    // Single ')' found, insert one ')' to make it "))"
                    insertions++;
                }

                if (openCount > 0) {
                    // Match with an existing '('
                    openCount--;
                } else {
                    // No '(' available, insert one '('
                    insertions++;
                }
            }
        }

        // Each unmatched '(' requires two ')'s
        insertions += openCount * 2;

        return insertions;
    }
}