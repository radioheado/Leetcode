class MyCircularQueue {

    private int capacity;
    private int[] queue;
    private int head;
    private int cur;
    private int count;
    
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        head = 0;
        cur = -1;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        // if queue is full
        if(count == capacity){
            return false;
        }
        
        // if the cur pointer reaches the end, we'll start over
        // else, we'll increment cur
        if(cur+1 == capacity){
            cur = 0;
        }else{
            cur++;
        }
        
        queue[cur] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0){
            return false;
        }
        
        // if the queue will be empty after this, refresh the vars
        if(count == 1){
            head = 0;
            cur = -1;
        }else{
            if(head == capacity-1){
                head = 0;
            }else{
                head++;
            }  
        }
        count--;
        return true;
    }
    
    public int Front() {
        return count == 0 ? -1 : queue[head];
    }
    
    public int Rear() {
        return count == 0 ? -1 : queue[cur];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */