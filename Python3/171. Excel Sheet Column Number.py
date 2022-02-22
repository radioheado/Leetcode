class Solution:
    def titleToNumber(self, s: str) -> int:
        A = ord('A')-1
        result = 0
                
        for i in range(len(s)):
            result = result*26 + ord(s[i]) - A
            #print('result = %d' %result)
        
        return result