class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int lastSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSide = sum - lastSum - nums[i];
            if (lastSum == rightSide) {
                return i;
            }
            lastSum += nums[i];
        }

        return -1;
    }
}