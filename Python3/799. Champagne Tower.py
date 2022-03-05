class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        sim = [[0] * k for k in range(1, query_row+3)]
        sim[0][0] = poured
        
        for r in range(query_row+1):
            for c in range(r+1):
                flow = (sim[r][c] - 1) / 2.0
                if flow > 0:
                    sim[r+1][c] += flow
                    sim[r+1][c+1] += flow
        
        return min(1, sim[query_row][query_glass])