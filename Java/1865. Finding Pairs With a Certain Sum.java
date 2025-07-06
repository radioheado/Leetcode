class FindSumPairs {
    private Map<Integer, Integer> count1;
    private Map<Integer, Integer> count2;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        count1 = new HashMap<>();
        count2 = new HashMap<>();
        for (int n: nums1) {
            count1.put(n, count1.getOrDefault(n, 0) + 1);
        }

        for (int n: nums2) {
            count2.put(n, count2.getOrDefault(n, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int num = this.nums2[index];
        count2.put(num, count2.get(num) - 1);
        this.nums2[index] += val;
        count2.put(num + val, count2.getOrDefault(num + val, 0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for (int n: count1.keySet()) {
            ans += count1.get(n) * count2.getOrDefault(tot - n, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */