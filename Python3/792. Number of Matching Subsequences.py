class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        buckets = defaultdict(list)
        
        for word in words:
            buckets[word[0]].append(word[1:])
        
        count = 0
        for c in s:
            old = buckets[c]
            # clear the old state
            buckets[c] = []
            
            for suffix in old:
                if not suffix:
                    count += 1
                else:
                    buckets[suffix[0]].append(suffix[1:])
                    
        return count