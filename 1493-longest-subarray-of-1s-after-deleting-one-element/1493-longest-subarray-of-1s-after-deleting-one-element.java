class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { zeroCount++; }

            while (zeroCount > 1) {
                if (nums[left] == 0) {zeroCount--;}
                left++;
            }

            maxLen = Math.max(maxLen, i - left);
        }
        return maxLen;
    }
}