class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        num = 0
        ans = []
        for n in nums:
            num = ((num << 1) + n) % 5
            ans.append(num == 0)

        return ans