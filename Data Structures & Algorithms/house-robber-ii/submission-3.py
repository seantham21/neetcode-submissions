class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
            
        memo = [-1] * len(nums)

        def dp(arr, i):
            if i < 0:
                return 0        
            if memo[i] != -1:
                return memo[i]

            take = arr[i] + dp(arr, i - 2)
            notake = dp(arr, i - 1)
            memo[i] = max(take, notake)
            return memo[i]
        
        res = dp(nums[1:], len(nums) - 2)
        memo = [-1] * len(nums)
        res = max(res, dp(nums[:-1], len(nums) - 2))
        return res
            
