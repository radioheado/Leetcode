class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        nums = defaultdict(int)
        for t in tasks:
            nums[t] += 1

        ans = 0
        for n in nums.values():
            if n == 1:
                return -1

            elif n % 3 == 0:
                ans += n // 3

            else:
                ans += n // 3 + 1

        return ans    
