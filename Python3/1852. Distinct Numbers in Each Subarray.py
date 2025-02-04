class Solution:
    def distinctNumbers(self, nums: List[int], k: int) -> List[int]:
        num_count = defaultdict(int)
        distinct_count = 0
        ans = []

        for i, n in enumerate(nums):
            if num_count[n] == 0:
                distinct_count += 1
            num_count[n] += 1

            if i >= k:
                num_count[nums[i - k]] -= 1
                if num_count[nums[i - k]] == 0:
                    distinct_count -= 1

            if i >= k - 1:
                ans.append(distinct_count)

        return ans