class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i=n; i<2*n; i++) {
            int second = nums[i] << 10;
            nums[i - n] |= second;
        }  

        int allOnes = (int) Math.pow(2, 10) - 1;
        for (int i=n-1; i>=0; i--) {
            int second = nums[i] >> 10;
            int first = nums[i] & allOnes;
            nums[2*i+1] = second;
            nums[2*i] = first;
        } 

        return nums;
    }
}