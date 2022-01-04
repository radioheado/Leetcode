class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.isWord = False

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children[w]
        cur.isWord = True    

    def search(self, word: str) -> bool:
        cur = self.root
        for w in word:
            cur = cur.children.get(w)
            if not cur:
                return False
        
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for p in prefix:
            cur = cur.children.get(p)
            if not cur:
                return False
        
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)