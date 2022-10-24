class Solution:
    def similarRGB(self, color: str) -> str:
        def find(colors: str) -> str:
            num = int(colors, 16)
            r = round(num / 17)
            return hex(r)[-1] * 2
            
        ans = '#'
        for i in range(1, 6, 2):
            ans += find(color[i: i+2])
        return ans