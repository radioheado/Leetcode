class Solution:
    def makeGood(self, s: str) -> str:
        diff = ord('a') - ord('A')
        ans = s[0]
        
        for i, c in enumerate(s[1:], 1):
            # delete the last char from ans
            if ans and abs(ord(c) - ord(ans[-1])) == diff:
                ans = ans[:-1]
        
            # add current char to ans
            else:
                ans += c
                
        return ans