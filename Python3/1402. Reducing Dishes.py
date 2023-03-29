class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort(reverse = True)
        suffix, maxSum = 0, 0

        for s in satisfaction:
            suffix += s
            if suffix <= 0:
                break
            maxSum += suffix

        return maxSum