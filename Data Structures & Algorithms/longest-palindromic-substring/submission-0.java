class Solution {
    private static Boolean[][] memo;

    public String longestPalindrome(String s) {
        memo = new Boolean[s.length()][s.length()];
        int reslen = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if ((dp(s, i, j)) && (j - i + 1 > reslen)) {
                    reslen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public boolean dp(String s, int i, int j) {
        if ((i < 0) || (j >= s.length())) {
            return false;
        }

        if (i >= j) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = dp(s, i + 1, j - 1);
        } else {
            memo[i][j] = false;
        }

        return memo[i][j];
    }
}
