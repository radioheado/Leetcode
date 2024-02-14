class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos, neg = 0, 1
        ans = [0] * len(nums)

        for i, n in enumerate(nums):
            if n > 0:
                ans[pos] = n
                pos += 2
            else:
                ans[neg] = n
                neg += 2
        
        return ans
            