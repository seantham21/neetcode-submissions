class Solution {
    int[] memo = null;

    public int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        } else {
            if (memo[amount] != -2) { return memo[amount]; }

            int minNum = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = dp(coins, amount - coin);
                if (res != -1) {
                    minNum = Math.min(minNum, 1 + res);
                }

            }
            memo[amount] = (minNum == Integer.MAX_VALUE) ? -1 : minNum;
            return memo[amount];
        }
    }

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = -2;
        }
        memo[0] = 0;

        int minNum = dp(coins, amount);
        return memo[amount];
        // (minNum == (Integer.MAX_VALUE / 2) + 1) ? -1 : minNum;
    }
}
