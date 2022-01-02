class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        modulo = collections.defaultdict(int)
        pairs = 0
        
        for t in time:
            pairs += modulo[(60-t)%60]
            modulo[t%60] += 1
            
        return pairs
            
        