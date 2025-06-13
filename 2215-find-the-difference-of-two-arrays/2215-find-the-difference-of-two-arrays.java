import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        
        for (int num : nums1) {
            map.computeIfAbsent(num, k -> new HashSet<>()).add(1);
        }

        for (int num : nums2) {
            map.computeIfAbsent(num, k -> new HashSet<>()).add(2);
        }

        List<Integer> nums1List = new ArrayList<>();
        List<Integer> nums2List = new ArrayList<>();
        for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            if (value.size() == 2) continue;

            if (value.contains(1)) nums1List.add(entry.getKey());
            if (value.contains(2)) nums2List.add(entry.getKey());
        }

        answer.add(nums1List);
        answer.add(nums2List);
        return answer;
    }
}