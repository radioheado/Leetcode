class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        mapping = {}
        
        # use this to record the chars that have already been mapped
        seen = set()
        
        for i in range(len(s)):
            
            # the mapping between s[i] and t[i] already exists
            # check if they are identical
            if s[i] in mapping:
                if mapping[s[i]] == t[i]:
                    continue
                else:
                    return False
            else:
                # check if t[i] has already been mapped
                if t[i] in seen:
                    return False
                mapping[s[i]] = t[i]
                seen.add(t[i])
            
        return True