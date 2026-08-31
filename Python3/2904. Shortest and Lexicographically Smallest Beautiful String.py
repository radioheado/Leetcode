class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        l = count = 0
        ans = s

        def compare(s1: str, s2: str) -> str:
            if len(s1) < len(s2):
                return s1
            elif len(s1) > len(s2):
                return s2
            else:
                return min(s1, s2)

        for r, n in enumerate(s):
            count += n == '1'
            
            while count > k:
                count -= s[l] == '1'
                l += 1

            while l < len(s) and s[l] == '0':
                l += 1
            
            if count == k:
                ans = compare(ans, s[l: r+1])
        
        return ans if count >= k else ""