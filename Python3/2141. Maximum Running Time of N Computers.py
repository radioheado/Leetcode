class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        right = sum(batteries) // n
        left = 1

        while left < right:
            target = right - (right - left) // 2
            extra = sum(min(power, target) for power in batteries)

            if extra // n >= target:
                left = target
            else:
                right = target - 1

        return left