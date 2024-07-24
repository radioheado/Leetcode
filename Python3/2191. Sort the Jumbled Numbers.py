class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        mapped = []
        for i, n in enumerate(nums):
            num = 0
            for c in str(n):
                num = num * 10 + mapping[int(c)]

            mapped.append((num, i))

        mapped.sort()
        return [nums[i] for (n, i) in mapped]