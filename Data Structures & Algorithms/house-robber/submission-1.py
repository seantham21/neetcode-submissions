class Solution:
    def rob(self, nums: List[int]) -> int:
        memo = [-1] * len(nums)

        def dp(i):
            if i < 0:
                return 0

            if memo[i] != -1:
                return memo[i]        
            
            res = max(nums[i] + dp(i - 2), dp(i - 1))
            memo[i] = max(memo[i], res)
            return res
        
        return dp(len(nums) - 1)
