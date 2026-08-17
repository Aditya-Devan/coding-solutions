class StockSpanner {
    public Stack<Integer> s;
    public ArrayList<Integer> prices;

    public StockSpanner() {
        s = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int ans;
        prices.add(price);

        while (!s.isEmpty() && price >= prices.get(s.peek())) {
            s.pop();
        }

        if (s.isEmpty()) {
            ans = prices.size();  
        } else {
            int prevHigh = s.peek();
            ans = prices.size() - 1 - prevHigh;
        }

        
        s.push(prices.size() - 1);

        return ans;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */