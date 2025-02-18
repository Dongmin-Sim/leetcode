class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();

        int idx1 = 0, idx2 = 0;

        while (idx1 < word1.length() && idx2 < word2.length()) {
            sb.append(word1.charAt(idx1));
            sb.append(word2.charAt(idx2));

            idx1++;
            idx2++;
        }

        if (word1.length() - word2.length() > 0) {
            for (int i = idx1; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
            }
        } else {
            for (int i = idx2; i < word2.length(); i++) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}