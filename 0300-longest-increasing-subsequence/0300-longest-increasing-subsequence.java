class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (lis.isEmpty() || lis.get(lis.size() - 1) < cur) {
                lis.add(cur);
            } else {
                int l = 0, r = lis.size()-1;
                int m = 0;
                while (l <= r) {
                    m = l + (r - l) / 2;
                    if (lis.get(m) < cur) {
                        l = m + 1;
                    } else {
                        r = m-1;
                    }
                }

                lis.set(l, cur);
            }
        }

        return lis.size();
    }
}