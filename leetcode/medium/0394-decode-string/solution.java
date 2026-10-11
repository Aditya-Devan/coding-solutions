class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder token = new StringBuilder();
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                st.push(token.toString());
                st.push(String.valueOf(num));
                token.setLength(0);
                num = 0;
            } else if (c == ']') {
                String repeatNumStr = st.pop();
                int repeatTimes = Integer.parseInt(repeatNumStr);
                String prevString = st.pop();
                
                StringBuilder decoded = new StringBuilder(prevString);
                String currentToken = token.toString();
                for (int k = 0; k < repeatTimes; k++) {
                    decoded.append(currentToken);
                }
                token = decoded;
            } else {
                token.append(c);
            }
        }
        return token.toString();
    }
}