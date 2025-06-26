class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int pre = 0, l = nums.length - 1;

        for (int i = 0; i <= l; i++) {
            if (nums[i] == key) {
                int left = Math.max(pre, i - k);
                int right = Math.min(l, i + k);
                for (int j = left; j <= right; j++) 
                    ans.add(j);
                
                pre = right + 1;
            }
        }

        return ans;
    }
}