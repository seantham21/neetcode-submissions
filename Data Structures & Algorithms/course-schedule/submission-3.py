class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = {i: [] for i in range(numCourses)}
        for req in prerequisites:
            preMap[req[1]].append(req[0])
        
        visited = set()
        def dfs(course):
            if course in visited:
                return False
            if preMap[course] == []:
                return True
            
            visited.add(course)
            for req in preMap[course]:
                if not dfs(req):
                    return False
            visited.remove(course)
            preMap[course] = []
            return True

        for course in range(numCourses):
            if not dfs(course):
                return False
        
        return True
