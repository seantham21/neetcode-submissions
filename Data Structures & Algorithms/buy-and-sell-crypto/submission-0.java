class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int currProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[buy]) {
                currProfit = prices[i] - prices[buy];
                if (currProfit > maxProfit) {
                    maxProfit = currProfit;
                }
            } else {
                buy = i;
            }
        }
        return maxProfit;
    }
}
