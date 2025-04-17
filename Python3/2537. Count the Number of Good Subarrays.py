class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        N = len(nums)
        pairs, right = 0, -1
        ans = 0
        count = Counter()

        for left, num in enumerate(nums):
            while pairs < k and right + 1 < N:
                right += 1
                pairs += count[nums[right]]
                count[nums[right]] += 1
            if pairs >= k:
                ans += N - right
            
            count[num] -= 1
            pairs -= count[num]

        return ans