class Solution:
    def customSortString(self, order: str, s: str) -> str:
        chars = Counter(s)
        ans = ''

        for c in order:
            if c in chars:
                ans += c * chars[c]
                del chars[c]

        for c, v in chars.items():
            ans += c * v

        return ans