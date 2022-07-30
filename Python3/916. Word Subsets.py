class Solution:
    def countChars(self, w):
        ans = [0] * 26
        for i, c in enumerate(w):
            ans[ord(c) - ord('a')] += 1
        return ans
        
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        sets = [0] * 26
        # compute the max subset
        for w in words2:
            for i, c in enumerate(self.countChars(w)):
                sets[i] = max(sets[i], c)
            
        ans = []
        for w in words1:
            if all(x >= y for x, y in zip(self.countChars(w), sets)):
                ans.append(w)
                
        return ans