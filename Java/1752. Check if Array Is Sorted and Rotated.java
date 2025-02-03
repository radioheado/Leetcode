class Solution {
    public boolean check(int[] nums) {
        boolean head = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (!head) {
                    head = true;
                } else {
                    return false;
                }
            }
        }

        return head ? nums[0] >= nums[nums.length - 1] : true;
    }
}