class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int most;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        most = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > most) {
            most = f;
        }
        if (!group.containsKey(f)) {
            group.put(f, new Stack<>());
        }
        group.get(f).add(val);
    }
    
    public int pop() {
        int val = group.get(most).pop();
        freq.put(val, freq.get(val)-1);
        if (group.get(most).size() == 0) {
            most--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */