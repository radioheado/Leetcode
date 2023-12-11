class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        l = len(arr) / 4
        count = 1

        for i, n in enumerate(arr[1:], 1):
            if n != arr[i-1]:
                count = 1
            else:
                count += 1

            if count > l:
                return n

        return arr[-1]
            