class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> asterisksSt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openSt.push(i);
            } else if (ch == '*') {
                asterisksSt.push(i);
            } else {
                if (!openSt.isEmpty()) {
                    openSt.pop();
                } else if (!asterisksSt.isEmpty()) {
                    asterisksSt.pop();
                } else {
                    return false;
                }
            }
        }

       
        while (!openSt.isEmpty() && !asterisksSt.isEmpty()) {
            if (openSt.peek() > asterisksSt.peek()) {
                return false;
            }
            openSt.pop();
            asterisksSt.pop();
        }

        return openSt.isEmpty();
    }
}

