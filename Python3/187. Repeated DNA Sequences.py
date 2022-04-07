class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        patterns = collections.defaultdict(int)
        ans = []
        
        for i in range(9, len(s)):
            sub = s[i-9: i+1]
            if sub not in patterns:
                patterns[sub] = 1
            else:
                if patterns[sub] == 1:
                    ans.append(sub)
                    patterns[sub] += 1
                    
        
        return ans