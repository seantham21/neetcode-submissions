class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> latestPosition = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (latestPosition.containsKey(s.charAt(i))) {
                l = Math.max(l, latestPosition.get(s.charAt(i)) + 1);
            }
            latestPosition.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
