class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        N = len(nums)
        head_idx = [i for i in range(N)]

        for i, n in enumerate(nums[1:], 1):
            if n % 2 + nums[i - 1] % 2 == 1:
                head_idx[i] = head_idx[i - 1]
            else:
                head_idx[i] = i

        ans = []
        for s, e in queries:
            ans.append(head_idx[e] <= s)

        return ans