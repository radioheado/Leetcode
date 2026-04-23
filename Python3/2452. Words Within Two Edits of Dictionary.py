class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        trie = Trie()
        for word in dictionary:
            trie.add(word)

        ans = []
        for query in queries:
            if trie.find(query):
                ans.append(query)

        return ans

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def add(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children[w]
        cur.isWord = True

    def find(self, word: str) -> bool:
        def dfs(edits=0, i=0, cur=self.root) -> bool:
            if i == len(word) and cur.isWord:
                return True

            nxt = cur.children.get(word[i])
            if not nxt:
                edits += 1
                if edits > 2:
                    return False

            for nxt in cur.children.values():
                if dfs(edits, i + 1, nxt):
                    return True

            return False

        return dfs()

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isWord = False
