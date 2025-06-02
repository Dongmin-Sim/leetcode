class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPtr = 0;

        for (int nonZeroPtr = 0; nonZeroPtr < nums.length; nonZeroPtr++) {
            if (nums[nonZeroPtr] != 0) {
                int tmp = nums[nonZeroPtr];
                nums[nonZeroPtr] = nums[zeroPtr];
                nums[zeroPtr] = tmp;
                for (int i = zeroPtr; i <= nonZeroPtr; i++) {
                    if (nums[i] == 0) {
                        zeroPtr = i;
                        break;
                    }
                }
            }
        }
    }
}