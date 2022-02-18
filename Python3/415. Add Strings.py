class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        if len(num1) < len(num2):
            return self.addStrings(num2, num1)
        
        num1 = num1[::-1]
        num2 = num2[::-1]
        carry = 0
        ans = ""
        
        for i, n in enumerate(num1):
            n1 = int(n)
            n2 = int(num2[i]) if i < len(num2) else 0
            carry, rem = divmod(carry+n1+n2, 10)
            ans = str(rem) + ans
        
        if carry:
            ans = str(carry) + ans
            
        return ans