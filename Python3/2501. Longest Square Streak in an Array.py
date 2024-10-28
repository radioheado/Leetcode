class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        nums = set(nums)
        ans = -1

        while nums:
            num = nums.pop()
            cur = -1
            temp = num
            while temp > 1:
                if sqrt(temp) == floor(sqrt(temp)):
                    temp = int(sqrt(temp))
                    if temp in nums:
                        cur += 1
                        nums.remove(temp)
                else:
                    break

            temp = num
            while temp * temp <= 10 ** 5:
                temp *= temp
                if temp in nums:
                    cur += 1
                    nums.remove(temp)
                else:
                    break

            if cur != -1:
                ans = max(ans, cur + 2)

        return ans
