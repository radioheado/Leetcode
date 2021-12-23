class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # add the prerequisites to each course
        adjs = collections.defaultdict(list)
        for u, v in prerequisites:
            adjs[v].append(u)
            
        # use a list to denote the color status of each course
        # initially each course is marked as 0 
        # which means its color is WHITE, and has never been visited
        # if the color == 1, the course is under investigation
        # which means we encounter a cycle, thus no possible order exists
        # if the color == 2, the course has already been investigated
        # then we will not apply dfs to it again
        status = [0] * numCourses
        
        # use a flag to indicate there is a cycle
        self.possible = True
        
        result = []
        
        def dfs(course):
            # if a cycle has already been discovered, stop here
            if not self.possible:
                return
            
            # mark the current course as GRAY
            status[course] = 1
            
            # traverse all the adjacent courses
            if course in adjs:
                for nei in adjs[course]:
                    
                    # if the next course is not visited
                    if status[nei] == 0:
                        dfs(nei)
                        
                    # if the next course is being investigating
                    elif status[nei] == 1:
                        self.possible = False
            
            # mark the next course as BLACK            
            status[course] = 2
            result.append(course)
            
        for c in range(numCourses):
            if status[c] == 0:
                dfs(c)
                
        return result[::-1] if self.possible else []
                    