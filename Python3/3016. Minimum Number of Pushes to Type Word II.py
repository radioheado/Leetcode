class Solution:
    def minimumPushes(self, word: str) -> int:
        count = [0] * 26
        for c in word:
            count[ord(c) - ord('a')] += 1

        count.sort(reverse=True)
        ans = 0

        for i, c in enumerate(count):
            if c == 0:
                break

            ans += (i // 8 + 1) * c

        return ans