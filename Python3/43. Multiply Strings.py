class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1[0] == "0" or num2[0] == "0":
            return "0"
        
        # the result is reversed bits
        def add(x: list, y: list):
            
            i = 0       # index
            c = 0       # carry value
            ans = []

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

            #ans.reverse()

            return ans    
        
        # reverse the num strings
        num1 = num1[::-1]
        num2 = num2[::-1]
        product = [0]
        zeros = 0
        
        # result is reversed
        for i in num2:
            carry = 0
            temp = []
            
            for j in num1:
                
                p = int(i)*int(j)+carry
                carry = floor(p/10)
                res = p%10
                
                temp.append(res)
            
            if carry:
                temp.append(carry)
            
            #print("zeros = ", zeros)
            for k in range(zeros):
                temp.insert(0, 0)
            
            #print("temp = " ,temp)
            product = add(product, temp)
            #print("product = ", product)
            zeros += 1
            
        product.reverse() 
        return ''.join(str(digit) for digit in product)