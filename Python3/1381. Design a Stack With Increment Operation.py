class Node:
    def __init__(self, val: int):
        self.val = val
        self.next = None
        self.prev = None

class CustomStack:

    def __init__(self, maxSize: int):
        self.head = Node(-1)
        self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.count = 0
        self.maxSize = maxSize

    def push(self, x: int) -> None:
        if self.count < self.maxSize:
            node = Node(x)
            prev = self.tail.prev
            prev.next = node
            node.prev = prev
            node.next = self.tail
            self.tail.prev = node
            self.count += 1

    def pop(self) -> int:
        if self.count == 0:
            return -1

        self.count -= 1
        top = self.tail.prev
        prev = top.prev
        top.prev = None
        top.next = None

        prev.next = self.tail
        self.tail.prev = prev
        return top.val

    def increment(self, k: int, val: int) -> None:
        node = self.head.next
        for _ in range(k):
            if node == self.tail:
                break

            node.val += val
            node = node.next



# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)