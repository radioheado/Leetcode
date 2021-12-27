class Solution:
    def findComplement(self, num: int) -> int:
        binn = bin(num)[2:]
        flip = {'0': 1, '1': 0}
        rev = 0
        
        for i in binn:
            rev = rev*2 + flip[i]
            
        return rev