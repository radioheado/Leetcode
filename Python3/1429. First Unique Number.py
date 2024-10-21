class FirstUnique:

    def __init__(self, nums: List[int]):
        self.set = Counter(nums)
        self.head = Node(0)
        self.tail = Node(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.val_to_node = defaultdict(Node)

        cur = self.head
        for n in nums:
            if self.set[n] == 1:
                pre = cur
                cur = Node(n)
                pre.next = cur
                cur.next = self.tail
                cur.prev = pre
                self.tail.prev = cur
                self.val_to_node[n] = cur

    def showFirstUnique(self) -> int:
        if self.head.next != self.tail:
            cur = self.head.next
            return cur.val
        return -1

    def add(self, value: int) -> None:
        self.set[value] += 1

        # This is a unique number
        if self.set[value] == 1:
            pre = self.tail.prev
            cur = Node(value)
            pre.next = cur
            cur.prev = pre
            cur.next = self.tail
            self.tail.prev = cur

            # Add the node to the map
            self.val_to_node[value] = cur

        # Need to remove the node from the list
        elif self.set[value] == 2:
            node = self.val_to_node[value]
            pre, nxt = node.prev, node.next
            pre.next = nxt
            nxt.prev = pre

        
class Node:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None

# Your FirstUnique object will be instantiated and called as such:
# obj = FirstUnique(nums)
# param_1 = obj.showFirstUnique()
# obj.add(value)