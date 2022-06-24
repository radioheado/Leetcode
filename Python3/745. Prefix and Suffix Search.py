Trie = lambda: collections.defaultdict(Trie)

class WordFilter:
    def __init__(self, words: List[str]):
        self.trie = Trie()
        
        for i, w in enumerate(words):
            for j in range(len(w) + 1):
                cur = self.trie
                cur['weight'] = i
                word = w[j:] + '#' + w
                for c in word:
                    cur = cur[c]
                    cur['weight'] = i
        
    def f(self, prefix: str, suffix: str) -> int:
        cur = self.trie
        for c in suffix + '#' + prefix:
            if c not in cur:
                return -1
            cur = cur[c]
        return cur['weight']


# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(prefix,suffix)