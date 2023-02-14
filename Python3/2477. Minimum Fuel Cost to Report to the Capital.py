class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        adjs = defaultdict(list)

        for u, v in roads:
            adjs[u].append(v)
            adjs[v].append(u)

        fuel = 0

        def dfs(node = 0, parent = -1):
            rep = 1
            for a in adjs[node]:
                if a != parent:
                    rep += dfs(a, node)

            nonlocal fuel
            if node != 0:
                fuel += math.ceil(rep/seats)
            return rep

        dfs()
        return fuel