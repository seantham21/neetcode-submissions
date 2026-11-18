class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        pos = len(intervals)
        newL, newR = newInterval[0], newInterval[1]

        for i in range(len(intervals)):
            if intervals[i][0] < newL: 
                continue
            pos = i
            break
        
        l, r = pos - 1, pos
        while l >= 0 and intervals[l][1] >= newL:
            newL = intervals[l][0]
            newR = max(newR, intervals[l][1])
            l -= 1
            
        while r < len(intervals) and intervals[r][0] <= newR:
            newR = max(newR, intervals[r][1])
            r += 1
        
        res = intervals[:l + 1]
        res.append([newL, newR])
        res.extend(intervals[r:])
        
        return res
        
