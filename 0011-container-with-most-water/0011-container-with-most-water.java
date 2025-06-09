class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int diff = right - left;
            int minWall = Math.min(height[left], height[right]);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, minWall * diff);
        }

        return maxArea;
    }
}