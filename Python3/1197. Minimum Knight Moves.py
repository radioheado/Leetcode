class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        
        @lru_cache(maxsize = None)
        def dfs(r, c):
            if r + c == 0:
                return 0
            elif r + c == 2:
                return 2
            else:
                return min(dfs(abs(r-1), abs(c-2)), dfs(abs(r-2), abs(c-1))) + 1
            
        return dfs(abs(x), abs(y))