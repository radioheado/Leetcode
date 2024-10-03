class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] bucket = new int[1001];
        for (int n: nums) {
            bucket[n]++;
        }

        for (int i = 1000; i >= 0; i--) {
            if (bucket[i] == 1) 
                return i;
            
        }

        return -1;
    }
}