class Solution:
    def calculateTime(self, keyboard: str, word: str) -> int:
        indices = collections.defaultdict(int)
        for i, k in enumerate(keyboard):
            indices[k] = i

        ans = cur = 0
        for w in word:
            pos = indices[w]
            ans += abs(pos - cur)
            cur = pos
        return ans