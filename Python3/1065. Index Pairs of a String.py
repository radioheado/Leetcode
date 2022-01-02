class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        res = []
        
        for i, s in enumerate(text):
            
            for w in words:
                
                # if the first char matches
                if s == w[0]:
                    l = len(w)
                    if i+l <= len(text) and text[i:i+l] == w:
                        #print("current char = %s, index = %d, word = %s" %(s, i, w))
                        res.append([i, i+l-1])
        
        res.sort()                
        return res