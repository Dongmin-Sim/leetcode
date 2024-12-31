class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num)) {
                return true;
            }
            map.put(num, true);
        }
        return false;
    }
}