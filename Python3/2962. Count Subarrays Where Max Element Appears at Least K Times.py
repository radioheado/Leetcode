class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_num = max(nums)
        ans = r = count = 0
        size = len(nums)

        for l, n in enumerate(nums):
            if l > 0:
                count -= nums[l - 1] == max_num

            while r < size and count < k:
                count += nums[r] == max_num
                r += 1
            
            if count == k:
                ans += size - r + 1

        return ans