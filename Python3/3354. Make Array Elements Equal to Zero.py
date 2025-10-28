class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        total = sum(nums)
        pre = ans = 0
        for n in nums:
            pre += n
            if n == 0:
                if pre * 2 == total:
                    ans += 2
                elif abs(total - 2 * pre) == 1:
                    ans += 1

        return ans