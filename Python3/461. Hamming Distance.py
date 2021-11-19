class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        bx = bin(x)[2:]
        by = bin(y)[2:]
        
        bx = bx[::-1]
        by = by[::-1]
        #print(bx, by)
        
        i = 0
        count = 0
        
        while i<len(bx) or i<len(by):
            if i>len(bx)-1:
                count += int(by[i])
            elif i>len(by)-1:
                count += int(bx[i])
            else:
                count += int(bx[i])^int(by[i])
            i += 1
            
        return count
                
                
        
        
        