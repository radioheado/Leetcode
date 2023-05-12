class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        count = Counter(s)
        prev = -1

        for v in count.values():
            if prev == -1:
                prev = v
            
            if v != prev:
                return False

        return True