class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        ans = []
        left, right = 0, len(s)
        
        for c in s: 
            if c == 'I':
                ans.append(left)
                left += 1
            else:
                ans.append(right)
                right -= 1
        
        ans.append(left)
        return ans
        
            