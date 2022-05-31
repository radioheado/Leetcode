class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        seen = set()
        
        for i in range(len(s) - k + 1):
            #print(s[i: i+k])
            seen.add(s[i: i+k])
        #print(seen)    
        return len(seen) == pow(2, k)