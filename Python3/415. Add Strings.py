class Solution:
    def addStrings(self, x: str, y: str) -> str:
        i = 0       # index
        c = 0       # carry value
        ans = []
        x = x[::-1]
        y = y[::-1]
        
        while i<len(x) or i<len(y):
            
            if i >= len(x):
                #print("i >= len(x) ", i)
                p = int(y[i])+c
                c = floor(p/10)
                res = p%10
                    
            elif i >= len(y):
                #print("i >= len(y) ", i)
                p = int(x[i])+c
                c = floor(p/10)
                res = p%10
                    
            else:
                #print("i < ", i)
                p = int(x[i])+int(y[i])+c
                #print("p = ", p)
                c = floor(p/10)
                res = p%10
                
            #print("res = ", res)
            ans.append(res)
            #print("ans = ", ans)
            i += 1
        
        if c:
            ans.append(c)
        
        ans.reverse()
        return ''.join(str(digit) for digit in ans)