class Solution {
    public int numWays(int steps, int arrLen) {
        int m = steps;
        int n = Math.min(steps, arrLen);
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        int mod = 1000000007;
        
        for (int i = 1; i <= m; i++) {
            int[] newDp = new int[n];
            for (int j = 0; j < n; j++) {
                newDp[j] = dp[j];
                if (j > 0) {
                    newDp[j] = (newDp[j] + dp[j - 1]) % mod;
                }
                if (j < n - 1) {
                    newDp[j] = (newDp[j] + dp[j + 1]) % mod;
                }
            }
            dp = newDp;
        }
        
        return dp[0];
    }
}