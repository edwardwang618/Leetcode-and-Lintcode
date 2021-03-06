public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = (int) (1E9 + 7);
        
        // dp[k][i][j]是从(i, j)这个位置恰好走k步出界的路径数
        int[][][] dp = new int[N + 1][m][n];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int step = 1; step <= N; step++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (step == 1) {
                        for (int[] dir : dirs) {
                            int nextX = x + dir[0], nextY = y + dir[1];
                            if (!inBound(nextX, nextY, m, n)) {
                                dp[step][x][y]++;
                            }
                        }
                    } else {
                        for (int[] dir : dirs) {
                            int nextX = x + dir[0], nextY = y + dir[1];
                            if (inBound(nextX, nextY, m, n)) {
                                dp[step][x][y] += dp[step - 1][nextX][nextY];
                                dp[step][x][y] %= MOD;
                            }
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int k = 0; k <= N; k++) {
            res = (res + dp[k][i][j]) % MOD;
        }
        
        return res;
    }
    
    private boolean inBound(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPaths(1, 3, 3, 0, 1));
    }
}
