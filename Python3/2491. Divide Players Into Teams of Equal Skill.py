class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        buckets = [0] * 1001
        smin, smax = 1001, 0

        for s in skill:
            buckets[s] += 1
            smin = min(smin, s)
            smax = max(smax, s)

        ssum = smin + smax
        ans = 0
        for s in skill:
            partner = ssum - s
            if buckets[partner] == 0:
                return -1

            ans += s * partner
            buckets[partner] -= 1

        return ans // 2