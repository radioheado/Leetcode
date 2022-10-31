class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        same = defaultdict(int)
        comp = defaultdict(int)
        ans = 0
        
        for w in words:
            # two identical letters
            if w[0] == w[1]:
                if same.get(w, 0) == 1:
                    same[w] -= 1
                    ans += 4
                else:
                    same[w] += 1
            
            else:
                comp[w] += 1
                rev = ''.join(reversed(w))
                #print(rev)
                if comp.get(rev, 0) > 0:
                    ans += 4
                    comp[rev] -= 1
                    comp[w] -= 1
        
        for v in same.values():
            if v > 0:
                return ans + 2
            
        return ans        
                