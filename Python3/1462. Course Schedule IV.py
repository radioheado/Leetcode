class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        # reachable[i][j] means course i is a prerequisite of course j
        reachable = [[False] * numCourses for _ in range(numCourses)] 
        
        for u, v in prerequisites:
            reachable[u][v] = True

        for intermediate in range(numCourses):
            for src in range(numCourses):
                for tgt in range(numCourses):
                    reachable[src][tgt] = reachable[src][tgt] or (
                        reachable[src][intermediate] and 
                        reachable[intermediate][tgt]
                    )

        ans = []
        for u, v in queries:
            ans.append(reachable[u][v])

        return ans