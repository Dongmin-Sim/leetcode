class Solution {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int idx = 0;
        while (idx < s.length()) {
            char cur = s.charAt(idx);

            if (idx + 1 < s.length()) {
                char next = s.charAt(idx + 1);

                if (map.get(cur) < map.get(next)) {
                    result += map.get(next) - map.get(cur);
                    idx += 2;
                    continue;
                }
            }
            result += map.get(cur);
            idx++;
        }

        return result;
    }
}