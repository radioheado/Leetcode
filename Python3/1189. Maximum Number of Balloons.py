class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        count = {'b': 0, 'a': 0, 'l': 0, 'o': 0, 'n': 0}
        ans = inf

        for c in text:
            if c in count:
                count[c] += 1

        for c, n in count.items():
            if c in 'ban':
                ans = min(ans, n)
            elif c in 'lo':
                ans = min(ans, n // 2)

        return ans