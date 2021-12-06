class MyCircularQueue:

    def __init__(self, k: int):
        self.k = k
        self.q = [None]*self.k
        self.head = 0
        self.cur = -1
        self.count = 0
        #print("-------------------Start Over----------------")

    def enQueue(self, value: int) -> bool:
        
        # if queue is full, return False
        if self.count == self.k:
            return False
          
        # if the self.cur pointer reaches the end, we'll start over
        # else, we'll increment self.cur
        if self.cur+1 == self.k:
            self.cur = 0
        else:
            self.cur += 1
            
        self.q[self.cur] = value
        
        #print("enQueue: \t", self.head, self.cur, self.q)
        self.count += 1
        return True

    def deQueue(self) -> bool:
        # if the queue currently has no element
        if self.count == 0:
            return False
        
        # make the head pointer null
        self.q[self.head] = None
        
        # if the queue will be empty after this, refresh the vars
        if self.count == 1:
            self.head = 0
            self.cur = -1
            
        else:
            if self.head == self.k-1:
                self.head = 0
            else:
                self.head += 1
        self.count -= 1
           
        #print("deQueue: \t", self.head, self.cur, self.q)
        return True
        
    def Front(self) -> int:
        if self.count == 0:
            return -1
        #print("Front: \t", self.q[self.head])
        return self.q[self.head]

    def Rear(self) -> int:
        if self.count == 0:
            return -1
        #print("Rear: \t", self.q[self.cur])
        return self.q[self.cur]


    def isEmpty(self) -> bool:
        return self.count == 0

    def isFull(self) -> bool:
        return self.count == self.k


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()