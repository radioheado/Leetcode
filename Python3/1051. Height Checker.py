class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        copy = sorted(heights)
        res = 0
        
        for i in range(len(heights)):
            if heights[i] != copy[i]:
                res += 1
                
        return res
                