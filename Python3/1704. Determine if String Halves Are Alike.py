class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        v1 = v2 = 0
        vowels = set('aeiouAEIOU')
        
        while l < r:
            if s[l] in vowels:
                v1 += 1
            if s[r] in vowels:
                v2 += 1
            l += 1
            r -= 1
            
        return v1 == v2
        