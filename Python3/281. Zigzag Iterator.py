class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.list = []
        l1, l2 = len(v1), len(v2)
        p1 = p2 = 0
        while p1 < l1 or p2 < l2:
            if p1 < l1:
                self.list.append(v1[p1])
                p1 += 1
            if p2 < l2:
                self.list.append(v2[p2])
                p2 += 1
                
        self.pointer = 0
        self.size = l1 + l2

    def next(self) -> int:
        if self.hasNext():
            num = self.list[self.pointer]
            self.pointer += 1
            return num
        else:
            raise Exception

    def hasNext(self) -> bool:
        return self.pointer < self.size

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())