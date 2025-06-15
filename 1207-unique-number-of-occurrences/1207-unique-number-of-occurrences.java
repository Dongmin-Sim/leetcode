class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> countUnique = new HashSet<>();
        for (Integer value : map.values()) {
            if (countUnique.contains(value)) {
                return false;
            }

            countUnique.add(value);
        }
        return true;
    }
}