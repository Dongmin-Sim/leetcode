class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        if ('0' == s.charAt(0)) {
            return 0;
        }
        dp[1] = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            int before = s.charAt(i - 1) - '0';

            if (current != 0) {
                /// 현재 값이 0이 아닐때,
                dp[i + 1] += dp[i];

                if ((before == 0) || (current >= 7 && before >= 2)) {
                    continue;
                }

                dp[i + 1] += dp[i - 1];
            } else {
                /// 현재 값이 0일 때,
                if (before != 0) {
                    /// 이전 값은 1, 2만 가능
                    if (before == 1 || before == 2) {
                        dp[i + 1] += dp[i - 1];
                    }
                } else {
                    return 0;
                }
            }
        }

        return dp[s.length()];
    }
}