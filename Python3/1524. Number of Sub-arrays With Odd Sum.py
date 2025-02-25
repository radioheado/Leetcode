class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MODULO = 10 ** 9 + 7
        prefix = ans = 0

        even, odd = 1, 0

        for num in arr:
            prefix += num
            if prefix % 2:
                ans = (ans + even) % MODULO
                odd += 1
            else:
                ans = (ans + odd) % MODULO
                even += 1

        return ans