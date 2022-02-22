class Solution:
    def findReplaceString(self, ss: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        zipped = list(zip(indices, sources, targets))
        zipped.sort(key = lambda x: x[0])
        ans = ""
        pre = 0
        
        for i, s, t in zipped:
            #print("i = %s, s = %s, t = %s" %(i, s, t))
            ans += ss[pre: i]
            #print(ans)
            diff = len(s)
            
            # replaceable
            if ss[i: i+diff] == s:
                ans += t
            else:
                ans += ss[i: i+diff]
            
            pre = i+diff
            
        return ans if pre == len(ss) else ans+ss[pre:]