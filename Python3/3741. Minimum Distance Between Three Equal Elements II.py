class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        indices = defaultdict(list)
        ans = inf

        for i, n in enumerate(nums):
            indices[n].append(i)
            if len(indices[n]) >= 3:
                ans = min(ans, 2 * (indices[n][-1] - indices[n][-3]))

        return ans if ans != inf else -1