# dict + doubly linked list
class LRUCache:

    def __init__(self, capacity: int):
        # use a dict to map key: node
        # where node saves the value information
        self.cache = {}
        self.size = 0
        self.capacity = capacity
        self.head, self.tail = DLinkedNode(), DLinkedNode()
        
        # pseudo head and tail
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        node = self.cache.get(key, None)
        if not node:
            return -1
        
        # move the key to the head and return value
        self._move_to_head(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if not node:
            # initialize the new node
            node = DLinkedNode()
            node.key = key
            node.val = value
            
            self.cache[key] = node
            self._add_node(node)
            self.size += 1
            
            # need to pop the tail
            if self.size > self.capacity:
                tail = self._pop_tail()
                del self.cache[tail.key]
                self.size -= 1
        
        else:
            node.val = value
            self._move_to_head(node)
            
        
    def _add_node(self, node):
        # add new node right after head
        # head -> head.next     becomes     head -> node -> head.next
        node.prev = self.head
        node.next = self.head.next
        
        self.head.next.prev = node
        self.head.next = node
        
    def _remove_node(self, node):
        # remove a node 
        # prev -> node -> next     becomes     prev -> next
        prev = node.prev
        nxt = node.next
        prev.next = nxt
        nxt.prev = prev
        
    def _move_to_head(self, node):
        # move a node to head
        self._remove_node(node)
        self._add_node(node)
        
    def _pop_tail(self):
        # remove the least used node
        # which is the prev of the pseudo tail
        tail = self.tail.prev
        self._remove_node(tail)
        return tail
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

# Doubly linked list
class DLinkedNode():
    def __init__(self):
        self.key = 0
        self.val = 0
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        else:
            self.cache.move_to_end(key)
            return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key] = value
        if len(self.cache) > self.capacity:
            self.cache.popitem(last=False)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)