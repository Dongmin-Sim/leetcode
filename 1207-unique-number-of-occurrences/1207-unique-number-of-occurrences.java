class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] table = new int[1001];

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            Integer val = map.get(key);
            if (table[val] != 0) return false;
            table[val]++;
        }

        return true;
    }
}