class Solution:
    def maxDiff(self, num: int) -> int:
        first_none_nine = '9'
        s = str(num)
        t = s

        for c in s:
            if c != '9':
                first_none_nine = c
                break

        s = s.replace(first_none_nine, '9')
        
        if t[0] != '1' or len(t) == 1:
            t = t.replace(t[0], '1')
        else:
            p = 1
            while p < len(t) and (t[p] == '0' or t[p] == t[0]):
                p += 1
            
            if p < len(t):
                t = t.replace(t[p], '0')
        
        return int(s) - int(t)