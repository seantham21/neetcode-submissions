class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = {}
        for num in nums:
            if num not in counter:
                counter[num] = 0

            counter[num] += 1

        freq = [[] for i in range(len(nums))]
        for key, val in counter.items():
            freq[val - 1].append(key)

        res = []
        for i in range(len(freq) - 1, -1, -1):
            if k == 0:
                break
            
            if not freq[i]:
                continue

            for val in freq[i]:
                if k == 0:
                    break
                res.append(val)
                k -= 1
        
        return res
            