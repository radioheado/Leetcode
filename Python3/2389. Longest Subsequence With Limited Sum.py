class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()

        for i in range(1, len(nums)):
            nums[i] += nums[i-1]

        ans = []
        for q in queries:
            idx = bisect.bisect_right(nums, q)
            ans.append(idx)

        return ans