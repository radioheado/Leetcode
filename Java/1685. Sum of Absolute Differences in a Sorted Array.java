class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int left_sum = 0, right_sum = 0, l = nums.length;
        for (int n: nums) {
            right_sum += n;
        }

        for (int i = 0; i < l; i++) {
            int temp = nums[i] * i - left_sum + right_sum - nums[i] * (l - i);
            left_sum += nums[i];
            right_sum -= nums[i];
            nums[i] = temp;  
        }

        return nums;
    }
}