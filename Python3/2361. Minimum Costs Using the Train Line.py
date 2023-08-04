class Solution:
    def minimumCosts(self, regular: List[int], express: List[int], expressCost: int) -> List[int]:
        n = len(regular)
        reg = 0
        exp = expressCost
        ans = []

        for i in range(n):
            # two ways to get to a regular lane stop:
            #   1. previous regular + regular[cur]
            #   2. previous express + express[cur]
            #   no extra cost from express lane to regular lane
            reg = min(reg + regular[i], exp + express[i])

            # two ways to get to an express lane stop:
            #   1. current regular + expressCost
            #   2. previous express + express[cur]
            exp = min(reg + expressCost, exp + express[i])
            ans.append(min(reg, exp))

        return ans