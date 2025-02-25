class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (satisfy(mid, nums, threshold)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean satisfy(int mid, int[] nums, int threshold) {
        int cnt = 0;

        for (int num : nums) {
            int result = num / mid + (num % mid > 0 ? 1 : 0);
            cnt += result;
            if (cnt > threshold) {
                return false;
            }
        }

        return true;
    }
}