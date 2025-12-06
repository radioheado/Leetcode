class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        y_groups = defaultdict(int)
        prefix = ans = 0

        for _, y in points:
            y_groups[y] += 1

        for v in y_groups.values():
            segments = (v - 1) * v // 2
            ans = (ans + segments * prefix) % MOD
            prefix = (prefix + segments) % MOD

        return ans