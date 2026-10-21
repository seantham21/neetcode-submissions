class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        stack = [(0, [], 0)]  # (index, combination, total)

        while stack:
            i, curr, total = stack.pop()

            if total == target:
                res.append(curr)
                continue

            if i >= len(nums) or total > target:
                continue

            # Choice 2: Skip current number
            stack.append((i + 1, curr, total))

            # Choice 1: Include current number
            stack.append((i, curr + [nums[i]], total + nums[i]))

        return res