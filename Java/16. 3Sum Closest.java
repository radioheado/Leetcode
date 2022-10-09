class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int L = nums.length;
        if (L <= 3) {
            int ans = 0;
            for (int n: nums) {
                ans += n;
            }
            return ans;
        }
        
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE, l, r, temp;
        for (int i=0; i<L-2; i++) {
            l = i+1;
            r = L-1;
            while (l < r) {
                temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(ans - target)) {
                    ans = temp;
                }
                
                if (temp < target) {
                    l++;
                } else if (temp > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        
        return ans;
    }
}