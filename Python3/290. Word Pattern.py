class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        ptns = collections.defaultdict(list)
        
        for i, c in enumerate(pattern):
            ptns[c].append(i)
            
        s = s.split()
        
        if len(s) != len(pattern):
            return False
        
        # two chars cannot be mapped to the same word
        seen = set()
        
        for idx in ptns.values():
            p = s[idx[0]]
            if p in seen:
                return False
            
            seen.add(p)
            
            for i in range(1, len(idx)):
                if s[idx[i]] != p:
                    return False
                
        return True