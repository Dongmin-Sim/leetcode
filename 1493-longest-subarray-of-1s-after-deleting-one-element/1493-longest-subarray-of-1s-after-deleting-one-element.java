class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int max = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;

            if (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left);
            right++;
        }

        return max;
    }
}