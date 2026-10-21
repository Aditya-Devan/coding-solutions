class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums, k) - subArray(nums, k - 1);
    }

    private int subArray(int[] nums, int k) {
      int count = 0, left = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int right = 0; right < nums.length;) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);
            while (frequency.size() > k) {
                frequency.put(nums[left], frequency.get(nums[left]) - 1);
                if (frequency.get(nums[left]) == 0) {
                    frequency.remove(nums[left]);
                }
                left++;

            }
            count += right - left + 1;
            right++;
        }
        return count;

    }
}