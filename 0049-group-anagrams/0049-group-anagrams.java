class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);

            String k = Arrays.toString(key);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
                result.add(map.get(k));
            }

            map.get(k).add(s);
        }

        return result;
    }
}