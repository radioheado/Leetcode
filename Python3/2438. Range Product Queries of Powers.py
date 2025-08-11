class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10 ** 9 + 7
        powers = []
        prev = 0

        while n:
            if n & 1 == 1:
                powers.append(prev)
            prev += 1
            n >>= 1

        for i, _ in enumerate(powers[1:], 1):
            powers[i] += powers[i - 1]

        ans = []
        for s, e in queries:
            l = 0 if s == 0 else powers[s - 1]
            ans.append((1 << (powers[e] - l)) % MOD)

        return ans