class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, n = nums.length, r = nums[n-1] - nums[0], m;

        while (l < r) {
            m = (r - l) / 2 + l;
            if (feasible(nums, p, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean feasible(int[] nums, int p, int diff) {
        int n = nums.length, cur = 1, pre, ans = 0;
        while (cur < n) {
            if (nums[cur] - nums[cur-1] <= diff) {
                ans++;
                cur++;
            }
            cur++;
            if (ans >= p) {
                return true;
            }
        }
        return false;
    }
}