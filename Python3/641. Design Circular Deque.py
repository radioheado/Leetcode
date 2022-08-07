class MyCircularDeque:

    def __init__(self, k: int):
        self.size = 0
        self.capacity = k
        self.deque = [0] * k
        self.head = 0
        self.tail = 0

    def insertFront(self, value: int) -> bool:
        if self.isFull():
            return False
        
        if self.size > 0:
            if self.head == 0:
                self.head = self.capacity - 1
            else:
                self.head -= 1   
        # empty deque, reset it
        else:
            self.head = 0
            self.tail = 0
        
        self.deque[self.head] = value
        self.size += 1
        return True

    def insertLast(self, value: int) -> bool:
        if self.isFull():
            return False
        
        if self.size > 0:
            self.tail = (self.tail+1) % self.capacity
        # empty deque, reset it
        else:
            self.head = 0
            self.tail = 0
            
        self.deque[self.tail] = value
        self.size += 1
        return True

    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False
        
        self.head = (self.head+1) % self.capacity
        self.size -= 1
        return True

    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False
        
        self.tail = (self.tail-1) % self.capacity
        self.size -= 1
        return True

    def getFront(self) -> int:
        return self.deque[self.head] if self.size > 0 else -1

    def getRear(self) -> int:
        return self.deque[self.tail] if self.size > 0 else -1

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == self.capacity


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()