class Solution {
    private Boolean[][] memo;
    private Map<Integer, Integer> positionToIndexMap;

    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (stones[1] != 1) {
            return false;
        }

        positionToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positionToIndexMap.put(stones[i], i);
        }

        memo = new Boolean[n][n + 1];
        return solve(stones, 1, 1);
    }

    private boolean solve(int[] stones, int currentIndex, int lastJump) {
        if (currentIndex == stones.length - 1) {
            return true;
        }

        if (memo[currentIndex][lastJump] != null) {
            return memo[currentIndex][lastJump];
        }
        
        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
            if (nextJump <= 0) {
                continue;
            }

            int nextPosition = stones[currentIndex] + nextJump;

            if (positionToIndexMap.containsKey(nextPosition)) {
                int nextIndex = positionToIndexMap.get(nextPosition);
                if (solve(stones, nextIndex, nextJump)) {
                    return memo[currentIndex][lastJump] = true;
                }
            }
        }

        return memo[currentIndex][lastJump] = false;
    }
}