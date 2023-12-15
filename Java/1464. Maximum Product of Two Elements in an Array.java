class Solution {
    public int maxProduct(int[] nums) {
        int top = -1, sec = -1;
        for (int n: nums) {
            if (n >= top) {
                sec = top;
                top = n;
            } else if (n > sec) {
                sec = n;
            }
        }
        return (top - 1) * (sec - 1);
    }
}