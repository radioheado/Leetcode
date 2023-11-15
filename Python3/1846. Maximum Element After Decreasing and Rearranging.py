class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        n = len(arr)
        count = [0] * (n + 1)

        for num in arr:
            count[min(num, n)] += 1

        ans = 1
        for num in range(2, n + 1):
            ans = min(ans + count[num], num)

        return ans