class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];

        // 같은 구성,
        for (int i = 0; i < word1.length(); i++) {
            word1Count[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            word2Count[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (!(word1Count[i] == 0 && word2Count[i] == 0)) {
                if (word1Count[i] == 0 || word2Count[i] == 0) {
                    return false;
                }
            }
        }

        // 개수 패턴 동일,
        Arrays.sort(word1Count);
        Arrays.sort(word2Count);
        return Arrays.equals(word1Count, word2Count);
    }
}