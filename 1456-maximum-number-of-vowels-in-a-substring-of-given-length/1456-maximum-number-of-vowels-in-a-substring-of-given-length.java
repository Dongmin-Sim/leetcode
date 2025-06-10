class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));


        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                vowelCount++;
            }
        }
        int maxVowels = vowelCount;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) vowelCount++;
            if (set.contains(s.charAt(i - k))) vowelCount--;
            maxVowels = Math.max(maxVowels, vowelCount);
        }

        return maxVowels;
    }
}