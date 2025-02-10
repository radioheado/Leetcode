class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        diff = defaultdict(int)
        n = len(nums)
        bad_pairs = 0

        for i, n in enumerate(nums):
            good_pairs = diff.get(i - n, 0)
            bad_pairs += i - good_pairs
            diff[i - n] += 1

        return bad_pairs