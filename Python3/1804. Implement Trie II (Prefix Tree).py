class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.words = 0
        self.prefs = 0

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children[w]
            cur.prefs += 1
        cur.words += 1

    def countWordsEqualTo(self, word: str) -> int:
        cur = self.root
        for w in word:
            cur = cur.children.get(w)
            if not cur:
                return 0
        return cur.words

    def countWordsStartingWith(self, prefix: str) -> int:
        cur = self.root
        for w in prefix:
            cur = cur.children.get(w)
            if not cur:
                return 0
        return cur.prefs

    def erase(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children.get(w)
            cur.prefs -= 1
        cur.words -= 1


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.countWordsEqualTo(word)
# param_3 = obj.countWordsStartingWith(prefix)
# obj.erase(word)