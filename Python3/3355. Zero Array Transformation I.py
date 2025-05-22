class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        delta = [0] * (len(nums) + 1)
        for l, r in queries:
            delta[l] += 1
            delta[r + 1] -= 1

        operations = []
        cur = 0
        for d in delta:
            cur += d
            operations.append(cur)

        for op, target in zip(operations, nums):
            if op < target:
                return False
        
        return True