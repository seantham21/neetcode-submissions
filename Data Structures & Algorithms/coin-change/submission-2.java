class Solution {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dfs(coins, amount);
    }

    public int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin);
            if (res != -1) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            memo[amount] = -1;
        } else {
            memo[amount] = minCoins;
        }
        return memo[amount];
    }
}
