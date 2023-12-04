class Solution:
    def largestGoodInteger(self, num: str) -> str:
        start = 0
        ans = -1

        for i, n in enumerate(num[1:], 1):
            # start a new count
            if n != num[i-1]:
                start = i

            if i - start == 2:
                ans = max(ans, int(num[i-1]))
                # need to update the start pointer
                start = i
                
        return str(ans) * 3 if ans != -1 else ''