class Solution:
    def minimumLength(self, s: str) -> int:
        chars = Counter(s)
        ans = 0

        for v in chars.values():
            if v <= 2:
                ans += v
            elif v % 2:
                ans += 1
            else:
                ans += 2
                    
        return ans