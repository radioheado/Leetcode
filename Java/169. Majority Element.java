class Solution {
    public int majorityElement(int[] nums) {
        int pivot = nums[0], count = 0;
        for(int n: nums) {
            if(count == 0) {
                pivot = n;
            }
            count += n == pivot ? 1 : -1;
        }
        return pivot;
    }
}