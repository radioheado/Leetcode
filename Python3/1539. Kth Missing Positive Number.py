class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        start = arr[0] - 1
        if start >= k:
            return k

        k -= start
        prev = arr[0]

        for n in arr[1:]:
            diff = n - prev - 1
            if k <= diff:
                return prev + k

            k -= diff
            prev = n

        return arr[-1] + k