class Solution:
    def nextGreaterElement(self, n: int) -> int:
        quo = list(str(n))
        
        if n < 12:
            return -1
        
        '''if list(quo) == sorted(quo, reverse=True):
            return -1'''
        i, j = len(quo)-2, len(quo)-1
        
        while i >= 0:
            if int(quo[i]) < int(quo[i+1]):
                break
            if i == 0:
                return -1
            i -= 1
            
        while j > i:
            if int(quo[j]) > int(quo[i]):
                quo[i], quo[j] = quo[j], quo[i]
                break
            j -= 1
        
        tmp = quo[i+1:]
        tmp.reverse()
        res = quo[:i+1]
        res.extend(tmp)
        res = int(''.join(res))
        return res if res <= 2**31-1 else -1
        