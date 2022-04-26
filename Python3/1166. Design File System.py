class FileSystem:

    def __init__(self):
        self.root = Trie()

    def createPath(self, path: str, value: int) -> bool:
        return self.root.add(path, value)

    def get(self, path: str) -> int:
        return self.root.search(path)


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.createPath(path,value)
# param_2 = obj.get(path)

class Trie:
    def __init__(self):
        self.root = Node()
        
    def add(self, path: str, val: int) -> bool:
        path = path.strip('/')
        path = path.split('/')
        #print(path, val)
        cur = self.root
        for i, p in enumerate(path):
            # the intermediate p doesn't exist
            if p not in cur.children and i != len(path)-1:
                return False
            cur = cur.children[p]
        if cur.val != -1:
            return False
        cur.val = val
        return True
        
    def search(self, path) -> int:
        cur = self.root
        path = path.strip('/')
        for p in path.split('/'):
            cur = cur.children.get(p)
            # p does not exist
            if not cur:
                return -1
        return cur.val
        
        
class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.val = -1