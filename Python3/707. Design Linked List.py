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