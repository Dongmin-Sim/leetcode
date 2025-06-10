class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length <= k) {
            return getAvg(nums);
        }

        int start = 0, end = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            end = i;
            sum += nums[end];
        }

        double maxAvg = (double) sum / k;

        for (int i = 0; i < nums.length - k; i++) {
            sum -= nums[start++];
            sum += nums[++end];
            maxAvg = Math.max(maxAvg, (double) sum / k);
        }

        return maxAvg;
    }

    private double getAvg(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (double) sum / nums.length;
    }
}