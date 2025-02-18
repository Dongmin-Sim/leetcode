class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int idx = 0;
        while (idx < word1.length() || idx < word2.length()) {
            if (idx < word1.length()) {
                result.append(word1.charAt(idx));
            }
            if (idx < word2.length()) {
                result.append(word2.charAt(idx));
            }
            idx++;
        }
        
        return result.toString();
    }
}