class Solution {
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return lcs(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    public int lcs(String text1, int i, String text2, int j) {

        if ((i < 0) || (j < 0)) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res = 1 + lcs(text1, i - 1, text2, j - 1);
        } else {
            res = Math.max(lcs(text1, i - 1, text2, j), lcs(text1, i, text2, j - 1));
        }

        memo[i][j] = res;
        return res;
    }
}
