class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long[] prefix = new long[len];
        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int min = nums[0];
        int max = nums[len - 1];
        long ans = Long.MAX_VALUE;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int idx = findMaxIndex(nums, mid);
            
            long moves = 0;
            if (idx != -1) {
                // Elements from 0 to idx are <= mid
                long leftCount = idx + 1;
                long leftSum = prefix[idx];
                moves += (mid * leftCount) - leftSum;
                
                // Elements from idx + 1 to len - 1 are > mid
                long rightCount = len - 1 - idx;
                long rightSum = prefix[len - 1] - prefix[idx];
                moves += rightSum - (mid * rightCount);
            } else {
                // All elements are > mid
                long rightSum = prefix[len - 1];
                moves += rightSum - ((long) mid * len);
            }   

            ans = Math.min(ans, moves);

            // Cut the search space based on slope/counts
            // If the number of elements <= mid is less than elements > mid, 
            // we need a larger target to minimize absolute differences.
            int leftCount = (idx == -1) ? 0 : (idx + 1);
            int rightCount = len - leftCount;

            if (leftCount < rightCount) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return (int) ans;
    }

    private int findMaxIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}