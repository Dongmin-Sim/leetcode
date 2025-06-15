import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(getDistinctNums(nums1, nums2));
        res.add(getDistinctNums(nums2, nums1));

        return res;
    }

    private List<Integer> getDistinctNums(int[] nums1, int[] nums2) {
        HashSet<Integer> tmp = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums2) {
            set.add(num);
        }

        for (int num : nums1) {
            if (!set.contains(num)) {
                tmp.add(num);
            }
        }
        return new ArrayList<>(tmp);
    }
}