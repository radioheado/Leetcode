class Solution:
    def numSteps(self, s: str) -> int:
        steps, num = 0, int(s, 2)
        while num != 1:
            if num % 2:
                num += 1
            else:
                num //= 2
            steps += 1

        return steps