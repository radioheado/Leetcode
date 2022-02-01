class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        # not enough total chars in magazine
        if len(ransomNote) > len(magazine):
            return False
        
        chars = [0] * 26
        a = ord('a')
        
        for c in magazine:
            chars[ord(c) - a] += 1
            
        for c in ransomNote:
            #print("c = %s, chars[c] = %d" %(c, chars[ord(c)-a]))
            # not enough chars for c in magazine
            if chars[ord(c) - a] <= 0:
                return False
            
            chars[ord(c) - a] -= 1
            
        return True
        
        