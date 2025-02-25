class Solution {
    public String longestPalindrome(String s) {
        int max = 0, si = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;

            while (r < s.length() - 1 && s.charAt(i) == s.charAt(r + 1)) {
                r++;
            }

            while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }

            if (max < r - l + 1) {
                max = r - l + 1;
                si = l;
            }
        }

        return s.substring(si, si + max);
    }
}