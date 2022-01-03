class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        judge = [0]*n
        
        for u, v in trust:
            # u's out degree increment
            judge[u-1] += 1
        
            # v's in degree decrement
            judge[v-1] -= 1
            
        ans = -1
        
        for i, j in enumerate(judge):
            if j == -n+1:
                # haven't found any judges
                if ans == -1:
                    ans = i+1
                    
                # already found a judge, return false
                else:
                    return -1
                
        return ans
                    
            