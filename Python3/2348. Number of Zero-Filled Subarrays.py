class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        start = -1
        ans = 0

        for i, n in enumerate(nums):
            if n != 0:
                # we have marked a start
                if start != -1:
                    l = i - start
                    ans += (l+1) * l // 2
                start = -1
            else:
                if start == -1:
                    start = i

        # we have a tail with 0's
        if start != -1:
            l = len(nums) - start
            ans += (l+1) * l // 2

        return ans