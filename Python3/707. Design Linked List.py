# singly linked list
class MyLinkedList:

    def __init__(self):
        # sentinel node as the head
        self.head = LinkedList(0)
        self.size = 0

    def get(self, index: int) -> int:
        # check for invalid index
        if index < 0 or index >= self.size:
            return -1
        
        cur = self.head
        
        for i in range(index+1):
            #print(cur.val)
            cur = cur.next
            
        return cur.val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size or index < 0:
            return
           
        new = LinkedList(val)
        prev = self.head
        
        for i in range(index):
            prev = prev.next
        
        new.next = prev.next
        prev.next = new
        
        # increment the size
        self.size += 1 

    def deleteAtIndex(self, index: int) -> None:
        # check for invalid index:
        if index >= self.size or index < 0:
            return
        
        prev = self.head
        
        for i in range(index):
            prev = prev.next
            
        prev.next = prev.next.next
        
        # decrement the size
        self.size -= 1

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)

class LinkedList:
    
    def __init__(self, x):
        self.next = None
        self.val = x


# doubly linked list
class MyLinkedList:

    def __init__(self):
        # sentinel nodes as the head and tail
        self.head = LinkedList(0)
        self.tail = LinkedList(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0

    def get(self, index: int) -> int:
        # check for invalid index
        if index < 0 or index >= self.size:
            return -1
        
        # check which side the index falls in: left half or right half
        # so we can query it faster from the head or the tail 
        if index + 1 < self.size - index:
            
            # move from the head
            cur = self.head
            
            # get the desired node
            for i in range(index+1):
                cur = cur.next
        
        else:
            
            # move from the tail
            cur = self.tail
            for i in range(self.size - index):
                cur = cur.prev
            
        return cur.val

    def addAtHead(self, val: int) -> None:
        prec, succ = self.head, self.head.next
        
        self.size += 1
        new = LinkedList(val)
        new.prev = prec
        new.next = succ
        prec.next = new
        succ.prev = new

    def addAtTail(self, val: int) -> None:
        prec, succ = self.tail.prev, self.tail
        
        self.size += 1
        new = LinkedList(val)
        new.prev = prec
        new.next = succ
        prec.next = new
        succ.prev = new

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size or index < 0:
            return
           
        new = LinkedList(val)
        
        # check which side the index falls in: left half or right half
        if index < self.size-index:
            prec = self.head
        
            # get the preceding node
            for i in range(index):
                prec = prec.next
            
            # get the successor of the new node
            succ = prec.next
        
        # insert from the tail
        else:
            succ = self.tail
            
            # get the successor
            for i in range(self.size - index):
                succ = succ.prev
                
            # get the predecessor
            prec = succ.prev
        
        # make preceding node's next the new node's next
        # and make preceding node the new node's prev
        new.prev = prec
        new.next = succ
        prec.next = new
        succ.prev = new
        
        # increment the size
        self.size += 1 

    def deleteAtIndex(self, index: int) -> None:
        # check for invalid index:
        if index >= self.size or index < 0:
            return
        
        # check which side the index falls in: left half or right half
        if index < self.size-index:
            prec = self.head
        
            # get the preceding node
            for i in range(index):
                prec = prec.next
            
            # get the successor of the deleted node
            succ = prec.next.next
        
        # delete from the tail
        else:
            succ = self.tail
            
            # get the successor
            for i in range(self.size - index - 1):
                succ = succ.prev
                
            # get the predecessor of the deleted node
            prec = succ.prev.prev
        
        prec.next = succ
        succ.prev = prec
        # decrement the size
        self.size -= 1

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)

# doubly linked list
class LinkedList:
    
    def __init__(self, x):
        self.next = None
        self.prev = None
        self.val = x