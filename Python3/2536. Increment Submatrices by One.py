class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        # Initialize 2D difference array
        diff = [[0] * n for _ in range(n)]

        for r1, c1, r2, c2 in queries:
            # Add +1 at the top-left of the rectangle
            # This means: "start adding +1 from here"
            diff[r1][c1] += 1

            # Place -1 just to the right of the rectangle
            # This stops horizontal propagation of the +1 beyond column c2
            if c2 + 1 < n:
                diff[r1][c2 + 1] -= 1

            # Place -1 just below the rectangle
            # This stops vertical propagation of the +1 beyond row r2
            if r2 + 1 < n:
                diff[r2 + 1][c1] -= 1

            # The bottom-right boundary cell receives both -1 effects
            # so we add +1 here to counteract the double subtraction.
            # This keeps the outside-bottom-right region unchanged.
            if r2 + 1 < n and c2 + 1 < n:
                diff[r2 + 1][c2 + 1] += 1

        # Build the final matrix:
        # First accumulate row-wise prefix sums
        for r in range(n):
            for c in range(1, n):
                diff[r][c] += diff[r][c - 1]

        # Then accumulate column-wise prefix sums
        for c in range(n):
            for r in range(1, n):
                diff[r][c] += diff[r - 1][c]

        return diff