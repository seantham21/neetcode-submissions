class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        lastSeen = {}
        l, r = 0, 0
        res = 0

        while r < len(s):
            curr = s[r]
            if curr in lastSeen:    
                l = max(l, lastSeen[curr] + 1)

            res = max(res, r - l + 1)
            lastSeen[curr] = r
            r += 1

        return res
