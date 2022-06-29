class Solution:
    def minDeletions(self, s: str) -> int:
        chars = Counter(s)
        chars = sorted(chars.items(), key = lambda x: x[1])
        ans = 0
        #print(chars)
        count = ['0'] * (chars[-1][1] + 1)
        for c, n in chars:
            # this number has not been claimed
            if count[n] == '0':
                count[n] = c
                continue
            
            i = n
            # search for an unclaimed position
            while count[i] != '0':
                ans += 1
                i -= 1
            
            # exclude 0 count of this char
            if i != 0:
                count[i] = c
        
        return ans
            