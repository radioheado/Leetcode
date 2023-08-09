class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        nums.sort()
        n = len(nums)

        def feasible(diff: int) -> bool:
            ans = 0
            cur = 1

            while cur < n:
                pre = nums[cur - 1]
                if nums[cur] - pre <= diff:
                    ans += 1
                    # if qualified, increment twice
                    cur += 1

                cur += 1
                if ans >= p:
                    return True

            return False       
                
        l, r = 0, nums[n - 1] - nums[0]
        while l < r:
            m = (r - l) // 2 + l
            if feasible(m):
                r = m
            else:
                l = m + 1

        return l        