class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        counter = Counter(nums)
        num = [(counter[key], key) for key in counter.keys()]
        num.sort(key = lambda x: (x[0], -x[1]))
        i = 0

        for c, n in num:
            while c:
                nums[i] = n
                i += 1
                c -= 1

        return nums