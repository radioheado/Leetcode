class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        ans = longest = 0
        for l, w in dimensions:
            diagonal = l * l + w * w
            if diagonal > longest:
                ans = l * w
                longest = diagonal
            elif diagonal == longest:
                ans = max(ans, l * w)
        
        return ans