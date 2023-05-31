class Bitset {
    private int[] set, rev;
    private int zeros, ones, total;

    public Bitset(int size) {
        zeros = total = size;
        ones = 0;
        set = new int[size];
        rev = new int[size];
        Arrays.fill(rev, 1);
    }
    
    public void fix(int idx) {
        if (set[idx] == 0) {
            zeros--;
            ones++;
        }
        set[idx] = 1;
        rev[idx] = 0;
    }
    
    public void unfix(int idx) {
        if (set[idx] == 1) {
            zeros++;
            ones--;
        }
        set[idx] = 0;
        rev[idx] = 1;
    }
    
    public void flip() {
        int temp = zeros;
        zeros = ones;
        ones = temp;

        int[] t = set;
        set = rev;
        rev = t;
    }
    
    public boolean all() {
        return ones == total;
    }
    
    public boolean one() {
        return ones > 0;
    }
    
    public int count() {
        return ones;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int n: set) {
            if (n == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */