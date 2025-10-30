class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        return target[0] + sum(max(target[i + 1] - target[i], 0) for i in range(len(target) - 1))