class Solution:
    def reverseVowels(self, s: str) -> str:
        l, r = 0, len(s) - 1
        s = list(s)
        left = right = -1
        vowels = set('aeiouAEIOU')
        
        while l <= r:
            if s[l] in vowels:
                if left == -1:
                    left = l
                    l += 1
            else:
                l += 1
                
            if s[r] in vowels:
                if right == -1:
                    right = r
                    r -= 1
            else:
                r -= 1
                
                
            if left != -1 and right != -1:
                s[left], s[right] = s[right], s[left]
                left = right = -1
                
        return ''.join(s)
                