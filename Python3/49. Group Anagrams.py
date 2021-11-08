class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        patterns = collections.defaultdict(list)
        
        for s in strs:
            patterns[tuple(sorted(s))].append(s)
            
        return patterns.values()