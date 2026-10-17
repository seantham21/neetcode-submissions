class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int res = 0;

        while (sell < prices.length) {
            if (prices[buy] <= prices[sell]) {
                res = Math.max(res, prices[sell] - prices[buy]);
                sell++;
            } else {
                buy = sell;
                sell++;
            }
        }

        return res;
    }
}
