class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            tmp = []
            while num:
                tmp.append(num % 10)
                num //= 10
            tmp.reverse()
            ans.extend(tmp)

        return ans