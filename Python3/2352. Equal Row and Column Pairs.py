class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        rows = collections.defaultdict(int)

        for row in grid:
            temp = ''
            for r in row:
                temp += str(r) + ','
            rows[temp] += 1

        ans = 0
        for col in range(len(grid[0])):
            temp = ''
            for r in range(len(grid)):
                temp += str(grid[r][col]) + ','
            ans += rows[temp]
        
        return ans