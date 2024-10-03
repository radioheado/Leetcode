class Node:
    def __init__(self, freq: int) -> None:
        self.freq = freq
        self.prev = None
        self.next = None
        # Records the keys with this frequency
        self.keys = set()

class AllOne:

    def __init__(self):
        # Dummy head and tail
        self.head = Node(0)
        self.tail = Node(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.keyToNode = {}

    def remove(self, node: Node) -> None:
        # Delete a node from the linked list
        pre = node.prev
        nxt = node.next
        pre.next = nxt
        nxt.prev = pre

    def inc(self, key: str) -> None:
        if key in self.keyToNode:
            node = self.keyToNode[key]
            count = node.freq

            # Remove the current key from the frequency node
            node.keys.remove(key)
            nxt = node.next

            # The next node with count + 1 doesn't exist
            if nxt == self.tail or nxt.freq != count + 1:
                newNode = Node(count + 1)
                newNode.keys.add(key)
                newNode.prev = node
                newNode.next = nxt
                node.next = newNode
                nxt.prev = newNode
                self.keyToNode[key] = newNode

            # Add key to the existing count + 1 node
            else:
                nxt.keys.add(key)
                self.keyToNode[key] = nxt

            # The current node has no more keys left
            if not node.keys:
                self.remove(node)

        # The current key does not exist
        else:
            first = self.head.next

            # No actual node exists or the lowest count is not 1
            if first == self.tail or first.freq > 1:
                newNode = Node(1)
                newNode.keys.add(key)
                newNode.prev = self.head
                newNode.next = first
                self.head.next = newNode
                first.prev = newNode
                self.keyToNode[key] = newNode
            
            # Insert key into the existing count node
            else:
                first.keys.add(key)
                self.keyToNode[key] = first


    def dec(self, key: str) -> None:
        node = self.keyToNode[key]
        # Remove key from the current node
        node.keys.remove(key)
        count = node.freq

        # Remove key from the hashmap
        if count == 1:
            del self.keyToNode[key]

        else:
            prev = node.prev
            # The node with count - 1 frequency doesn't exist
            if prev == self.head or prev.freq != count - 1:
                newNode = Node(count - 1)
                newNode.keys.add(key)
                newNode.prev = prev
                newNode.next = node
                prev.next = newNode
                node.prev = newNode
                self.keyToNode[key] = newNode

            # Decrement the existing node with count - 1 frequency
            else:
                prev.keys.add(key)
                self.keyToNode[key] = prev

        # Remove the node if no more keys left
        if not node.keys:
            self.remove(node)


    def getMaxKey(self) -> str:
        if self.tail.prev == self.head:
            return ""
        
        return next(iter(self.tail.prev.keys))

    def getMinKey(self) -> str:
        if self.head.next == self.tail:
            return ""

        return next(iter(self.head.next.keys))


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()