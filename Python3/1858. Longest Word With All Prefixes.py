class Solution:
    def longestWord(self, words: List[str]) -> str:
        root = Trie()
        for w in words:
            root.insert(w)

        ans = ''
        for w in words:
            if len(w) < len(ans):
                continue
            pref = root.prefix(w)
            if len(pref) > len(ans):
                ans = pref
            elif len(pref) == len(ans):
                ans = min(ans, pref)

        return ans

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, w: str) -> None:
        node = self.root
        for c in w:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]

        node.isWord = True

    def prefix(self, w: str) -> str:
        node = self.root
        for c in w:
            node = node.children[c]
            if not node.isWord:
                return ''
        return w