public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            res += Math.max(0, prices[i + 1] - prices[i]);
        }
        
        return res;
    }
}
