class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        l, r = 1, max(quantities)

        def isValid(p: int, stores: int) -> bool:
            for q in quantities:
                d = ceil(q / p)
                if stores >= d:
                    stores -= d
                else:
                    return False

            return True

        while l < r:
            m = (r - l) // 2 + l
            # This number is valid, keep it as a candidate and try smaller ones
            if isValid(m, n):
                r = m
            
            # This number is not valid, try bigger ones
            else:
                l = m + 1

        return r