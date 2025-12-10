class Solution:
    def countPermutations(self, complexity: List[int]) -> int:
        MOD = 10 ** 9 + 7
        min_val = complexity[0]

        for c in complexity[1:]:
            if c <= min_val:
                return 0

        ans = 1
        for f in range(1, len(complexity)):
            ans = (ans * f) % MOD

        return ans