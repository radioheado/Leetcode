class Solution:
    def myAtoi(self, s: str) -> int:
        
        ans = 0
        sign = 1;
        
        # delete leading whitespaces
        s = s.lstrip()
        #print("s = ", s)
        if not s:   return 0
        
        # check if the current leading char is "-" or "+"
        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        
        # compute ans
        for c in s:
            if not c.isdigit():
                break
            
            # sometimes s doesn't have signs
            if ans >= (2**31-int(c))/10 and sign == 1:
                return 2**31-1
            elif ans > (2**31-int(c))/10 and sign == -1:
                return -2**31
            else:
                ans = ans*10 + int(c)
         
        return sign*ans