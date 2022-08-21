class SparseVector {
    private List<int[]> num;
    private int len = 0;
    
    SparseVector(int[] nums) {
        num = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                num.add(new int[] {i, nums[i]});
                len++;
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0, v1 = 0, v2 = 0;
        
        while (v1 < this.len && v2 < vec.len) {
            int[] l1 = this.num.get(v1);
            int[] l2 = vec.num.get(v2);
            if (l1[0] > l2[0]) {
                v2++;
            } else if (l1[0] < l2[0]) {
                v1++;
            } else {
                product += l1[1] * l2[1];
                v1++;
                v2++;
            }
        }
        
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);