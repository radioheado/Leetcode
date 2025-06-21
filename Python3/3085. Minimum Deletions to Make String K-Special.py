class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        chars = Counter(word)
        freqs = list(chars.values())

        ans = inf
        for freq in freqs:
            cur = 0
            for f in freqs:
                if f < freq:
                    cur += f
                elif f > freq + k:
                    cur += f - freq - k
                
                if cur > ans:
                    break

            ans = min(ans, cur)

        return ans