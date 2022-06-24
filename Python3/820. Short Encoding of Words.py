class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        words = list(set(words))
        Trie = lambda: collections.defaultdict(Trie)
        
        trie = Trie()
        ans = 0
        
        for word in words:
            cur = trie
            for c in word[::-1]:
                if '#' in cur:
                    ans -= cur.pop('#')
                cur = cur[c]
            if not cur:
                cur['#'] = len(word) + 1
                ans += cur['#']
        
        return ans
                
            