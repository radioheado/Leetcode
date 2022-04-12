class Solution:
    def frequencySort(self, s: str) -> str:
        res = ''
        c = collections.Counter(s)
        c = sorted(c.items(), key = lambda obj: obj[1], reverse = True)
        
        #print(c)
        for key in c:
            res += key[0]*key[1]
            
        return(res)
        