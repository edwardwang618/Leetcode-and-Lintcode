public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                    }
                }
            }
        }
        
        return dp[len1][len2];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }
}
