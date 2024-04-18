class Solution:
    def hIndex(self, citations: List[int]) -> int:
        total = len(citations)
        counts = [0] * (total + 1)

        for c in citations:
            counts[min(c, total)] += 1

        for i in range(total, 0, -1):
            if counts[i] >= i:
                return i

            counts[i - 1] += counts[i]

        return 0