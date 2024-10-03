class CustomStack {

    private int[] stack;
    private int[] increments;
    private int topIndex;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increments = new int[maxSize];
        topIndex = -1;
    }
    
    public void push(int x) {
        if (topIndex < stack.length - 1) {
            stack[++topIndex] = x;
        }
    }
    
    public int pop() {
        if (topIndex < 0) {
            return -1;
        }

        int top = stack[topIndex] + increments[topIndex];
        if (topIndex > 0) {
            increments[topIndex - 1] += increments[topIndex];
        }

        // Reset the increment for the current position
        increments[topIndex--] = 0;
        return top;
    }
    
    public void increment(int k, int val) {
        if (topIndex >= 0) {
            increments[Math.min(topIndex, k - 1)] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */