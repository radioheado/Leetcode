class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i=nums.length-1; i>=2; i--) {
            if (helper(nums[i], nums[i-1], nums[i-2])) {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
    
    private boolean helper (int x, int y, int z) {
        return ((x+y) > z && (y+z) > x && (x+z) > y) ? true : false;
    }
}