class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isWord = False
        self.count = 0

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, s: str):
        node = self.root
        for c in s:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
            node.count += 1
            
        node.isWord = True

    def prefix(self, s: str):
        node = self.root
        ans = 0
        for c in s:
            node = node.children[c]
            ans += node.count
            
        return ans


class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        root = Trie()
        for w in words:
            root.insert(w)

        ans = []
        for w in words:
            ans.append(root.prefix(w))

        return ans