class FreqStack {
    private HashMap<Integer, Integer> freqMap;
    private HashMap<Integer, Stack<Integer>> groupMap;
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
    
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        
        groupMap.putIfAbsent(freq, new Stack<>());
        groupMap.get(freq).push(val);
    }
    
    public int pop() {
        Stack<Integer> maxFreqStack = groupMap.get(maxFreq);
        int topVal = maxFreqStack.pop();
        
        freqMap.put(topVal, freqMap.get(topVal) - 1);
        
        if (maxFreqStack.isEmpty()) {
            maxFreq--;
        }
        
        return topVal;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */