class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False
            
        chars = Counter(s)
        odd = 0

        for v in chars.values():
            if v % 2:
                odd += 1

        return odd <= k