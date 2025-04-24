class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        num_count = len(set(nums))
        r = cur_count = ans = 0
        window = Counter()
        total = len(nums)

        for l, num in enumerate(nums):
            if l > 0:
                remove = nums[l - 1]
                window[remove] -= 1
                if window[remove] == 0:
                    cur_count -= 1
            
            while r < total and cur_count < num_count:
                add = nums[r]
                window[add] += 1
                if window[add] == 1:
                    cur_count += 1

                r += 1

            if cur_count == num_count:
                ans += total - r + 1

        return ans