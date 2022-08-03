class NumArray {

    private int[] tree;
    private int   n;
    
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n*2];
        for (int i=0; i<n; i++) {
            tree[i+n] = nums[i];
        }
        for (int i=n-1; i>0; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }
    
    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        int l, r;
        while (index > 0) {
            l = index;
            r = index;
            if (index % 2 == 0) {
                r = index + 1;
            } else {
                l = index - 1;
            }
            tree[index/2] = tree[l] + tree[r];
            index /= 2;
        }
    }
    
    public int sumRange(int l, int r) {
        l += n;
        r += n;
        int sum = 0;
        while (l <= r) {
            if (l%2 == 1) {
                sum += tree[l];
                l++;
            }
            if (r%2 == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */