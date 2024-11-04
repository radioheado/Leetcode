class Solution:
    def compressedString(self, word: str) -> str:
        comp = []
        prefix = word[0]
        p_count = 1
        
        for i, c in enumerate(word[1:], 1):
            if c == prefix:
                p_count += 1
            else:
                if p_count:
                    comp.append(str(p_count) + prefix)
                prefix = c
                p_count = 1
                continue
            
            if p_count == 9:
                comp += ['9' + c]
                p_count = 0

        if p_count:
            comp += str(p_count) + prefix
        return ''.join(comp)