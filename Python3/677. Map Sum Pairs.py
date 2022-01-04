class Node:
    def __init__(self):
        self.children = collections.defaultdict(Node)
        self.val = 0
        

class MapSum:

    def __init__(self):
        self.root = Node()
        self.map = {}

    def insert(self, key: str, val: int) -> None:
        diff = val - self.map.get(key, 0)
        self.map[key] = val
        cur = self.root
        for k in key:
            cur = cur.children[k]
            cur.val += diff

    def sum(self, prefix: str) -> int:
        cur = self.root
        for p in prefix:
            cur = cur.children.get(p)
            if not cur:
                return 0
            
        return cur.val

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)