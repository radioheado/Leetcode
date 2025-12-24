class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        removed = 0
        sort = [False] * len(strs)

        for c in range(len(strs[0])):
            if all(sort[r] or strs[r][c] <= strs[r + 1][c] for r in range(len(strs) - 1)):
                for r in range(len(strs) - 1):
                    if strs[r][c] < strs[r + 1][c]:
                        sort[r] = True
            else:
                removed += 1

        return removed