class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        max_num = max(nums)
        count = [0] * (max_num + 1)
        for n in nums:
            count[n] += 1

        ans = left = 0
        #print(count)
        for i, n in enumerate(count):
            if n <= 1:
                continue
            ans += n - 1
            count[i] = 1
            if i < len(count) - 1:
                count[i + 1] += n - 1
            else:
                left = n - 1

        #print(count, left)
        left -= 1
        if left:
            ans += (1 + left) * left // 2

        return ans