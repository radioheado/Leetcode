class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] delta = new int[nums.length + 1];
        for (int[] q: queries) {
            delta[q[0]]++;
            delta[q[1] + 1]--;
        }

        int[] operations = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += delta[i];
            operations[i] = cur;
        }

        for (int i = 0; i < nums.length; i++) {
            if (operations[i] < nums[i]) {
                return false;
            }
        }
        
        return true;
    }
}