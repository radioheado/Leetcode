class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        nums = list(set(arr))
        nums.sort()

        map = {num: rank + 1 for rank, num in enumerate((nums))}
        for i, a in enumerate(arr):
            arr[i] = map[a]

        return arr