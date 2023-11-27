class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        array_min = arrays[0][0]
        array_max = arrays[0][-1]
        ans = 0

        for array in arrays[1:]:
            ans = max(ans, abs(array[-1] - array_min), abs(array[0] - array_max))
            array_min = min(array[0], array_min)
            array_max = max(array[-1], array_max)

        return ans