class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        nums = [-n for n in nums]
        heapify(nums)
        score = 0

        while nums and k:
            highest = -heappop(nums)
            score += highest
            heappush(nums, -ceil(highest / 3))
            k -= 1

        return score