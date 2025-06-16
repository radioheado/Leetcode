class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        t = s
        first_none_nine = '9'

        for n in s:
            if n != '9':
                first_none_nine = n
                break
        
        max_num = s.replace(first_none_nine, '9')
        min_num = t.replace(t[0], '0')
        
        return int(max_num) - int(min_num)