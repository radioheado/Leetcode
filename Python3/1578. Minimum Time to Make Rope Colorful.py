class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        ans = 0
        p, pre = 0, colors[0]
        
        for c, cur in enumerate(colors[1:], 1):
            if pre == cur:
                # release current balloon
                if neededTime[c] < neededTime[p]:
                    ans += neededTime[c]
                    
                # release previous balloon
                else:
                    ans += neededTime[p]
                    p, pre = c, cur
            else:
                p, pre = c, cur
                    
        return ans