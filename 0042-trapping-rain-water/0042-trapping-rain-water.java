class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int water = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                int currentHeight = height[l];
                if (currentHeight < lmax) {
                    water += lmax - currentHeight;
                } else {
                    lmax = currentHeight;
                }
            } else {
                r--;
                int currentHeight = height[r];
                if (currentHeight < rmax) {
                    water += rmax - currentHeight;
                } else {
                    rmax = currentHeight;
                }
            }
        }
        return water;
    }
}