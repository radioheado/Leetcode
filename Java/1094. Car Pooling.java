class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] bucket = new int[1001];
        
        for(int[] t: trips){
            bucket[t[1]] += t[0];
            bucket[t[2]] -= t[0];
        }
        
        int total = 0;
        
        for(int b: bucket){
            total += b;
            if(total > capacity){
                return false;
            }
        }
        
        return true;
    }
}