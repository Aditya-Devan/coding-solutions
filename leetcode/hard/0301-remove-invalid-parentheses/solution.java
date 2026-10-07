

class Solution {

    public void solve(String s, List<String> ans, Set<String> visited, int removals) {
        
        if (visited.contains(s)) {
            return;
        }

        visited.add(s);

        if (removals == 0) {
            // Check if valid answer
            if (findRemovals(s) == 0) {
                ans.add(s);
            }
            return;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isLetter(s.charAt(i))) { // Skip non-parenthesis characters
                String leftPart = s.substring(0, i);
                String rightPart = s.substring(i + 1);
                String joined = leftPart + rightPart;
                solve(joined, ans, visited, removals - 1);
            }
        }
    }

    public int findRemovals(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }

    public List<String> removeInvalidParentheses(String s) {
        int minRemovals = findRemovals(s);
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        solve(s, ans, visited, minRemovals);
        return ans;
    }
}
