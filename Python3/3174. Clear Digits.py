class Solution:
    def clearDigits(self, s: str) -> str:
        chars = []
        
        for c in s:
            if c.isdigit():
                chars.pop()
            else:
                chars.append(c)

        return ''.join(chars)