class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        left = 0
        for right, n in enumerate(arr):
            if n % 2 == 0:
                left = right + 1
            else:
                if right - left == 2:
                    return True

        return False