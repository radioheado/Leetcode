class Solution {
    public int minSwaps(int[] data) {
        int ones = 0, cur_one = 0, smallest;
        for (int n: data) {
            if (n == 1) ones++;
        }
        smallest = ones;
        
        for (int i=0; i<data.length; i++) {
            cur_one += data[i];
            if (i == ones-1) {
                smallest = Math.min(smallest, ones - cur_one);
            } else if (i >= ones) {
                cur_one -= data[i - ones];
                smallest = Math.min(smallest, ones - cur_one);
            }
        }
        
        return smallest;
    }
}