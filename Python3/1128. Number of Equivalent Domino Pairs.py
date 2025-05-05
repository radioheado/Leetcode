class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        ans = 0
        pairs = Counter()

        for d in dominoes:
            d.sort()
            d = (d[0], d[1])
            ans += pairs[d]
            pairs[d] += 1      

        return ans