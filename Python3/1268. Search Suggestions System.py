class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        trie = Trie()
        
        for p in products:
            trie.insert(p)
        
        return trie.search(searchWord)
                
class Trie:
    def __init__(self):
        self.root = Node()
        
    def insert(self, word: str) -> None:
        cur = self.root
        for w in word:
            cur = cur.children[w]
            bisect.insort_left(cur.rec, word)
            #print("add: ", cur.rec)
            if len(cur.rec) > 3:
                cur.rec.pop(-1)
            #print("popped: ", cur.rec)    

    def search(self, word: str) -> list:
        cur = self.root
        ans = []
        for w in word:
            # case 1: Null children from last loop
            if not cur:
                ans.append([])
                continue
                
            cur = cur.children.get(w)
            # case 2: current char does not exist
            if not cur:
                ans.append([])
            else:
                ans.append(cur.rec)
        return ans
    
class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.rec = []