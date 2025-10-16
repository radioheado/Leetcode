class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        mods = Counter()
        for n in nums:
            mods[n % value] += 1

        for num in range(len(nums)):
            if mods[num % value] == 0:
                return num
            mods[num % value] -= 1
        
        return len(nums)