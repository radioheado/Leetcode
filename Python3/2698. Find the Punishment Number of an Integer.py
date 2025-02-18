class Solution:
    def __init__(self):
        # (n, sum): n is the punished number
        #           sum is the prefix sum of punished numbers
        self.punishment = [0] * 1001

        def canPartition(num: int, target: int) -> bool:
            if target < 0 or num < target:
                return False

            if num == target:
                return True

            return (canPartition(num // 10, target - num % 10) or
                    canPartition(num // 100, target - num % 100) or
                    canPartition(num // 1000, target - num % 1000)
                    )

        for i in range(1, 1001):
            if canPartition(i * i, i):
                self.punishment[i] = self.punishment[i - 1] + i * i
            else:
                self.punishment[i] = self.punishment[i - 1]


    def punishmentNumber(self, n: int) -> int:
        return self.punishment[n]