class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
            
        horizontalCuts.sort()
        verticalCuts.sort()
        
        h_diff = horizontalCuts[0]
        for i in range(1, len(horizontalCuts)):
            h_diff = max(h_diff, horizontalCuts[i] - horizontalCuts[i-1])
        h_diff = max(h_diff, h - horizontalCuts[-1])
            
        v_diff = verticalCuts[0]
        for i in range(1, len(verticalCuts)):
            v_diff = max(v_diff, verticalCuts[i] - verticalCuts[i-1])
        v_diff = max(v_diff, w - verticalCuts[-1])
            
        return h_diff * v_diff % (10**9 + 7)
            
        