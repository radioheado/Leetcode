class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        cur = arr[0]
        count = 0

        for i, n in enumerate(arr[1:], 1):
            if cur > n:
                count += 1
            else:
                cur = n
                count = 1

            if count == k:
                return cur

        return cur