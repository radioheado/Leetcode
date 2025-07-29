class Solution {
    public int countHillValley(int[] nums) {
        int pre = 0, ans = 0;
        for (int cur = 1; cur < nums.length - 1; cur++) {
            if (nums[cur] == nums[cur + 1]) {
                continue;
            }

            if ((nums[pre] < nums[cur] && nums[cur] > nums[cur + 1]) || 
                (nums[pre] > nums[cur] && nums[cur] < nums[cur + 1])) {
                    ans++;
                    pre = cur;
                 }
        }
        return ans;
    }
}