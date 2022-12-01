class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counts = Counter(arr)
        occur = set()
        
        for v in counts.values():
            if v in occur:
                return False
            occur.add(v)
            
        return True