class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
        R, C = len(matrix), len(matrix[0])
        
        # compute 2D prefix sums
        ps = [[0] * (C+1) for _ in range(R+1)]
        for r in range(1, R+1):
            for c in range(1, C+1):
                ps[r][c] = ps[r][c-1] + ps[r-1][c] - ps[r-1][c-1] + matrix[r-1][c-1]
                
        count = 0
        # reduce to 1D prefix sum problem
        for r1 in range(1, R+1):
            for r2 in range(r1, R+1):
                sums = defaultdict(int)
                sums[0] = 1
                
                for c in range(1, C+1):
                    # current prefix sum
                    cur = ps[r2][c] - ps[r1-1][c]
                    count += sums[cur - target]
                    
                    # incremetn current prefix sum's count
                    sums[cur] += 1
                    
        return count