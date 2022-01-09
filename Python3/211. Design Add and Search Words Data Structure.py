class WordDictionary:

    def __init__(self):
        self.root = Node()

    def addWord(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children[w]
        cur.isWord = True

    def search(self, word: str) -> bool:
        
        # a helper function to match the dots
        def match(node: Node, word: str, i: int) -> bool:
            # reaches the null children of an end Trie node
            if not node:
                return False
            
            # reaches the end of the word
            if i == len(word):
                return node.isWord
        
            # if current char is not '.'
            if word[i] != '.':
                return node and match(node.children.get(word[i]), word, i+1)
            
            # if current char is '.'
            else:
                for c in node.children.values():
                    if match(c, word, i+1):
                        return True
                return False
            
        return match(self.root, word, 0)
                
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

class Node:
    
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.isWord = False