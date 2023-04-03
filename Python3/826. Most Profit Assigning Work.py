class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        pairs = []
        for d, p in zip(difficulty, profit):
            pairs.append([d, p])
        pairs.sort()

        for i in range(1, len(pairs)):
            pairs[i][1] = max(pairs[i-1][1], pairs[i][1])

        difficulty = [x[0] for x in pairs]
        profit = [x[1] for x in pairs]
        ans = 0
        for w in worker:
            idx = bisect.bisect_right(difficulty, w) - 1
            if idx != -1:
                ans += profit[idx]

        return ans