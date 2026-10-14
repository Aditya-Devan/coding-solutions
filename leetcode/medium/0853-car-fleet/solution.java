class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> carPair = new ArrayList<>();
        Stack<Double> monotonicStack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            carPair.add(new int[] {position[i], speed[i]});
        }

        carPair.sort((a,b) -> b[0] - a[0]);
        for (int[] car : carPair) {
            double time = (double)(target - car[0]) / car[1];
            if (monotonicStack.size() > 0 && time <= monotonicStack.peek()) {
                continue;
            } 
            monotonicStack.push(time);
        }
        
        return monotonicStack.size();
    }
}