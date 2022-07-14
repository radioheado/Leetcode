class Solution:
    def freqAlphabets(self, s: str) -> str:
        a = ord('a')
        ans = ''
        i, L = 0, len(s)
        
        while i < L:
            #print(s[i])
            # this is an over-9 char
            if i < L-2 and s[i+2] == '#':
                ans += chr(int(s[i:i+2]) + a - 1)
                i += 2
            else:
                ans += chr(int(s[i]) + a - 1)
            i += 1
        
        return ans