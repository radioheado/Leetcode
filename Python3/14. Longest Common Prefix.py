class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0]
        
        
        for i in range(1, len(strs)):
            ls = len(strs[i])
            lp = len(prefix)
            
            # if current prefix is longer than the current string
            # cut it before investigation
            
            prefix = prefix[:min(lp, ls)]
                
            lp = len(prefix)    
            #print(prefix)
            
            j = 0
            
            while j < lp and prefix:
                #print(j)
                if prefix[j] != strs[i][j]:
                    prefix = prefix[:j]
                    break
                
                j += 1
                
            if not prefix:
                return ""
            
        return prefix