class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            int num = asteroids[i];

            if (st.isEmpty()) {
                st.push(num);
            } 
            else if (st.peek() > 0) { 
                if (num > 0) {
                    st.push(num); 
                } else {
                  
                boolean destroyed = false;
         while (!st.isEmpty() && st.peek() > 0 && Math.abs(num) > st.peek()) {
                     st.pop(); 
                 }
                if (!st.isEmpty() && st.peek() == Math.abs(num)) {
                  st.pop(); 
                   destroyed = true;
                 }
             if (st.isEmpty() || st.peek() < 0) {
             if (!destroyed) st.push(num);
              }
                }
            } 
            else { 
               // if (num < 0) {
                    st.push(num); 
                // } else {
                //     st.push(num);
                // }
            }
        }

      
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
