class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        N = len(pref)
        ans = 0

        for word in words:
            if len(word) >= N and word[:N] == pref:
                ans += 1

        return ans