class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        // get prefix
        prefixProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = nums[i] * prefixProduct[i - 1];
        }

        // ger suffix
        suffixProduct[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i] * suffixProduct[i + 1];
        }

        answer[0] = suffixProduct[1];
        answer[nums.length - 1] = prefixProduct[nums.length - 2];

        for (int i = 1; i < nums.length-1; i++) {
            answer[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }

        return answer;
    }
}