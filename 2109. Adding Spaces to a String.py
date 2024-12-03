class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        idx = 0
        ans = []
        
        for space_pos in spaces:

            while idx < space_pos:
                ans.append(s[idx])
                idx += 1

            ans.append(' ')

        ans = ''.join(ans)
        
        if idx < len(s):
            ans += s[idx: ]

        return ans