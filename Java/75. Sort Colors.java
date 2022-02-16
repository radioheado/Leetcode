class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length-1, cur = 0;
        while(cur <= two) {
            if(nums[cur] == 0) {
                int temp = nums[zero];
                nums[zero++] = nums[cur];
                nums[cur++] = temp;
            }
            else if(nums[cur] == 2) {
                int temp = nums[two];
                nums[two--] = nums[cur];
                nums[cur] = temp;
            }
            else {
                cur++;
            }
        }
    }
}