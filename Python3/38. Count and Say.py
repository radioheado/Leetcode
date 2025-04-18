class Solution:
    def countAndSay(self, n: int) -> str:
        ans = '1'
        for _ in range(n-1):
            count = 1
            pre = ans[0]
            temp = ''
            for i, c in enumerate(ans[1:], 1):
                if c == pre:
                    count += 1
                else:
                    temp += str(count) + pre
                    count = 1
                    pre = c
            temp += str(count) + pre
            ans = temp
            
        return ans
                