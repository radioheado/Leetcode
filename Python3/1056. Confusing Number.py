class Solution:
    def confusingNumber(self, n: int) -> bool:
        mapping = {0: 0,
                   1: 1,
                   6: 9,
                   8: 8,
                   9: 6}

        ans = ''
        for digit in str(n):
            d = int(digit)
            if d not in mapping:
                return False
            ans += str(mapping[d])
        
        return int(ans[::-1]) != n