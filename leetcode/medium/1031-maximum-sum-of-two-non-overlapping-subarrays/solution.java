class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int len = nums.length;
        int[] preSlide = new int[len];
        int[] backSlide = new int[len];

        int i = 0, j = 0, sum = 0, maxSum = -1;
        while (j < len) {
            sum += nums[j];
            if (j - i + 1 == firstLen) {
                maxSum = Math.max(sum, maxSum);
                preSlide[j] = maxSum;
                sum -= nums[i++];
            }
            j++;
        }

        i = len - 1;
        j = len - 1;
        sum = 0;
        maxSum = -1;
        while (i >= 0) {
            sum += nums[i];
            if (j - i + 1 == firstLen) {
                maxSum = Math.max(sum, maxSum);
                backSlide[i] = maxSum;
                sum -= nums[j--];
            }
            i--;
        }

        int i2 = 0, j2 = 0;
        int sum2 = 0;
        int finalAns = -1;
        while (j2 < len) {
            sum2 += nums[j2];
            if (j2 - i2 + 1 == secondLen) {
                int pre = -1;
                int post = -1;

                if (j2 - secondLen >= 0) {
                    pre = preSlide[j2 - secondLen];
                }
                if (j2 + 1 < len) {
                    post = backSlide[j2 + 1];
                }

                finalAns = Math.max(finalAns, sum2 + Math.max(pre, post));
                sum2 -= nums[i2++];
            }
            j2++;
        }

        return finalAns;
    }
}