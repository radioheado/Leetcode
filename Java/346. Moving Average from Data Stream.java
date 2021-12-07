class MovingAverage {
    
    private Queue<Integer> q;
    private double average;
    private int count;
    
    public MovingAverage(int size) {
        count = size;
        q = new LinkedList<>();
        average = 0;
    }
    
    public double next(int val) {
        if(q.size() == count){
            average = (average*count-q.poll()+val)/count;
            
        }else{
            average = (average*q.size()+val)/(q.size()+1);
        }
        q.add(val);
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */