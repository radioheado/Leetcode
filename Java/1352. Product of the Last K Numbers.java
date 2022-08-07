class ProductOfNumbers {
    private List<Integer> nums;
    private int zero, size;

    public ProductOfNumbers() {
        nums = new ArrayList();
        zero = -1;
        size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            nums.add(1);
            zero = size;
        } else {
            if (nums.isEmpty()) {
                nums.add(num);
            } else {
                nums.add(num * nums.get(size-1));
            }
        }
        size++;
    }
    
    public int getProduct(int k) {
        if (zero >= size - k) {
            return 0;
        } 
        return k == size ? nums.get(size-1) : nums.get(size-1) / nums.get(size-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */