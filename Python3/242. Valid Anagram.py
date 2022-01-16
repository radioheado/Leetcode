class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # if s and t have different lengths, incorrect
        if len(s) != len(t):
            return False
        
        # record the times of each char in s
        chars = collections.Counter(s)
        
        # iterate t
        for c in t:
            
            # c is not in s, false
            if c not in chars:
                return False
            
            # c is in s but it's already deducted to 0
            # which means there are more c in t
            if chars[c] > 0:
                chars[c] -= 1
            else:
                return False
            
        return True
        
        