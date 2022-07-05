class Solution {
    public int wiggleMaxLength(int[] nums) {
        int pos = 1, neg = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                pos = neg + 1;
            } else if (nums[i-1] > nums[i]) {
                neg = pos + 1;
            }
        }
        
        return Math.max(neg, pos);
    }
}