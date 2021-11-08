class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        i = 0
        ans = []
        
        a = a[::-1]
        b = b[::-1]
        
        # the result is reversed
        while i<len(a) or i<len(b):
            
            if i>=len(a):
                sum = int(b[i]) + carry
                
            elif i>=len(b):
                sum = int(a[i]) + carry
                
            else:
                sum = int(a[i]) + int(b[i]) + carry
            
            carry = floor(sum/2)
            res = sum%2
            
            ans.append(res)
            i += 1
            
        if carry:
            ans.append(carry)
            
        ans.reverse()
        
        return ''.join(str(digit) for digit in ans)