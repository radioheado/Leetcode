class MyCircularDeque {
    private int[] deque;
    private int head, tail, size, capacity;

    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        head = 0;
        tail = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull())   return false;
        
        if (size > 0) {
            if (head == 0) {
                head = capacity - 1;
            } else {
                head--;
            }
        } else {
            head = 0;
            tail = 0;
        }
        deque[head] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull())   return false;
        
        if (size > 0) {
            tail = (tail+1) % capacity;
        } else {
            head = 0;
            tail = 0;
        }
        deque[tail] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty())  return false;
        
        head = (head + 1) % capacity; 
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty())  return false;
        
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : deque[head];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : deque[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */