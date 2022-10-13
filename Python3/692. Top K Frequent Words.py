class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        n = len(words)
        count = Counter(words)
        buckets = [{} for _ in range(n + 1)]
        self.k = k
        
        def add(trie: Mapping, word: str) -> None:
            root = trie
            for w in word:
                if w not in root:
                    root[w] = {}
                root = root[w]
            root['#'] = {}
            
        def get(trie: Mapping, prefix: str) -> List[str]:
            if self.k == 0:
                return []
            ans = []
            if '#' in trie:
                self.k -= 1
                ans.append(prefix)
            for i in range(26):
                c = chr(ord('a') + i)
                if c in trie:
                    ans += get(trie[c], prefix + c)
            return ans
        
        # add word to its corresponding bucket by frequency
        for w, f in count.items():
            add(buckets[f], w)
            
        res = []
        for i in range(n, 0, -1):
            if self.k == 0:
                return res
            if buckets[i]:
                res += get(buckets[i], '')
            
        return res
            
        
        
