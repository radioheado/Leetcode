class StockSpanner {
    private Stack<int[]> stack;
    private int size;

    public StockSpanner() {
        stack = new Stack();
        size = 0;
    }
    
    public int next(int price) {
        size++;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        
        int res = stack.isEmpty() ? size : (size - stack.peek()[1]);
        stack.push(new int[] {price, size});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */