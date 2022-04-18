class Solution {
    public int arraySign(int[] nums) {
        int neg = 0;
        for(int n: nums) {
            if (n < 0) {
                neg++;
            } else if (n == 0) {
                return 0;
            }
        }
        return neg%2 == 1 ? -1 : 1;
    }
}