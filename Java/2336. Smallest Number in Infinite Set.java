class SmallestInfiniteSet {
    private int cur;
    private Set<Integer> set;
    private PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        cur = 1;
        set = new HashSet();
        heap = new PriorityQueue();
    }
    
    public int popSmallest() {
        if (!heap.isEmpty()) {
            int potential = heap.peek();
            if (potential < cur) {
                if (set.contains(potential)) {
                    set.remove(potential);
                }
                return heap.poll();
            }
        }
        cur++;
        return cur - 1;
    }
    
    public void addBack(int num) {
        if (!set.contains(num) && num < cur) {
            set.add(num);
            heap.
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */