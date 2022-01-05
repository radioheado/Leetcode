class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.word = False
        
class Trie:
    def __init__(self):
        self.root = Node()
        
    def insert(self, word):
        cur = self.root
        for w in word:
            cur = cur.children[w]
            # only add the prefixs
            if cur.word:
                break
        cur.word = True
        
    def replace(self, word):
        res = ""
        flag = False
        cur = self.root
        for w in word:
            cur = cur.children.get(w)
            if not cur:
                break
                
            # update res here by adding the current char
            res += w
            
            # reaches to the shortest word
            if cur.word:
                flag = cur.word
                break
            
        return res if res and flag else word
        

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        d = Trie()
        
        # add each word to the Trie structure
        for w in dictionary:
            d.insert(w)
        
        ans = []
        
        for s in sentence.split():
            ans.append(d.replace(s))
            
        return ' '.join(ans)