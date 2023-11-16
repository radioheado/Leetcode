class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        ans = []
        for i in range(len(nums)):
            cur = nums[i][i]
            ans.append('1' if cur == '0' else '0')

        return ''.join(ans)