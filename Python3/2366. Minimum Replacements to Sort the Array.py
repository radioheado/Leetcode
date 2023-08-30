class Solution:
    def minimumReplacement(self, nums: List[int]) -> int:
        ans = 0
        n = len(nums)

        for i in range(n - 2, -1, -1):
            cur, nxt = nums[i], nums[i + 1]

            # no need to break down the current number
            if cur <= nxt:
                continue

            # need to break down, count how many numbers are needed to make up cur
            count = (cur + nxt - 1) // nxt

            # only need count - 1 breaks to get the count numbers
            ans += count - 1

            # update nums[i] after the replacement
            nums[i] = cur // count

        return ans