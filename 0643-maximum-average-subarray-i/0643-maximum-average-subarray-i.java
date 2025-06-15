class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAvg = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            maxAvg = Math.max(maxAvg, sum / k);
        }
        
        return maxAvg;
    }
}