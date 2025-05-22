class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
            robbery(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            robbery(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int robbery(int[] nums) {
        int b1 = 0, b2 = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(b1, nums[i] + b2);
            b2 = b1;
            b1 = result;
        }

        return result;
    }
}