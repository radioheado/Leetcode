class Solution:
    def isNumber(self, s: str) -> bool:
        hasDot = hasEx = hasDigit = False
        
        for i, c in enumerate(s):
            if c.isdigit():
                hasDigit = True
                
            elif c in '+-':
                if i > 0 and s[i-1] != 'e' and s[i-1] != 'E':
                    return False
            
            elif c in 'eE':
                if hasEx or not hasDigit:
                    return False
                hasEx = True
                hasDigit = False
                
            elif c == '.':
                if hasEx or hasDot:
                    return False
                hasDot = True
            
            else:
                return False
            
        return hasDigit