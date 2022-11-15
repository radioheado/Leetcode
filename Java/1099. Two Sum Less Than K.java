class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        
        int[] count = new int[1001];
        Arrays.fill(count, 0);
        
        for (int n: nums) {
            count[n]++;
        }
        
        int ans = -1, l = 1, r = 1000;
        while (l <= r) {
            if (l + r >= k || count[r] == 0) {
                r--;
            } else {
                if (l == r) {
                    if (count[l] > 1) {
                        ans = Math.max(ans, l * 2);
                    }
                } else {
                    if (count[l] > 0) {
                        ans = Math.max(ans, l + r);
                    }
                }
                l++;
            }
        }
        return ans;
    }
}