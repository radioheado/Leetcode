class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        one_position = [0] * 32
        for c in candidates:
            bin_c = bin(c)[2:]
            N = len(bin_c)
            for i, b in enumerate(bin_c):
                if b == '1':
                    one_position[N - i - 1] += 1

        ans = 0
        for o in one_position:
            ans = max(ans, o)

        return ans