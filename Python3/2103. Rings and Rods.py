class Solution:
    def countPoints(self, rings: str) -> int:
        rods = collections.defaultdict(set)

        for i in range(0, len(rings) - 1, 2):
            rods[rings[i+1]].add(rings[i])

        ans = 0
        for v in rods.values():
            if len(v) == 3:
                ans += 1

        return ans