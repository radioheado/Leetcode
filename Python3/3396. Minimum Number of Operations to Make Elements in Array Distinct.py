class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        count  = Counter(nums)
        total = len(nums)
        i = 0
        ans = 0

        while total - i > len(count):
            for _ in range(3):
                if i < total:
                    count[nums[i]] -= 1
                    if count[nums[i]] == 0:
                        del count[nums[i]]
                i += 1
            ans += 1

        return ans