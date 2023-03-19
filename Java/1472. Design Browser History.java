class BrowserHistory {
    private Stack<String> stack;
    int size, ptr;

    public BrowserHistory(String homepage) {
        stack = new Stack();
        stack.push(homepage);
        ptr = 0;
        size = 1;
    }
    
    public void visit(String url) {
        while (ptr < size - 1) {
            stack.pop();
            size--;
        }
        stack.push(url);
        ptr = size;
        size++;
    }
    
    public String back(int steps) {
        ptr = Math.max(0, ptr - steps);
        return stack.get(ptr);
    }
    
    public String forward(int steps) {
        ptr = Math.min(size - 1, ptr + steps);
        return stack.get(ptr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */