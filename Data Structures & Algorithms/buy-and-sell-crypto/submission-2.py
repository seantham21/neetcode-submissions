class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = 0
        sell = 1
        res = 0

        while sell < len(prices):
            if prices[buy] <= prices[sell]:
                res = max(res, prices[sell] - prices[buy])
                sell += 1
            else:
                buy = sell
                sell += 1

        return res;