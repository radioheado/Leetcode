class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        ans = 0
        
        def backtrack(l: int, seen: set, count = 0):
            if l == len(s):
                nonlocal ans
                ans = max(ans, count)
                return 

            for r in range(l + 1, len(s) + 1):
                substring = s[l: r]
                if substring not in seen:
                    seen.add(substring)
                    backtrack(r, seen, count + 1)
                    seen.discard(substring)

        backtrack(0, set())
        return ans
