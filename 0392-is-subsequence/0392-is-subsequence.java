class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        
        int sPtr = 0;
        for (int i = 0; i < t.length(); i++) {

            if (t.charAt(i) == s.charAt(sPtr)) {
                if (sPtr == s.length() - 1) {
                    return true;
                }
                sPtr++;
            }

        }
        return false;
    }
}