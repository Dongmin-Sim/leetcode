class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int right = total - leftSum - nums[i];
            if (leftSum == right) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}