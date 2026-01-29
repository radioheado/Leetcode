class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        rows, cols = len(mat), len(mat[0])
        prefix = [[0] * cols for _ in range(rows)]

        for r in range(rows):
            for c in range(cols):
                left = prefix[r][c - 1] if c > 0 else 0
                up = prefix[r - 1][c] if r > 0 else 0
                prefix[r][c] += mat[r][c] + left + up
                prefix[r][c] -= prefix[r - 1][c - 1] if r > 0 and c > 0 else 0

        left, right = 0, min(rows, cols)

        def is_valid(target: int) -> bool:
            for r in range(target - 1, rows):
                for c in range(target - 1, cols):
                    total = prefix[r][c]
                    if r >= target: total -= prefix[r - target][c]      # subtract top rectangle
                    if c >= target: total -= prefix[r][c - target]      # subtract left rectangle
                    if r >= target and c >= target: 
                        total += prefix[r - target][c - target] 

                    if total <= threshold:
                        return True
            
            return False

        ans = 0
        while left <= right:
            target = right - (right - left) // 2
            if is_valid(target):
                ans = target
                left = target + 1
            else:
                right = target - 1

        return ans