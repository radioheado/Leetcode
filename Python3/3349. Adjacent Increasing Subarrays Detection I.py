class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        streak, left = 1, 0
        for i, n in enumerate(nums[1:], 1):
            if n > nums[i - 1]:
                streak += 1
            else:
                left = streak
                streak = 1
            
            if streak >= 2 * k or streak >= k and left >= k:
                return True

        return False