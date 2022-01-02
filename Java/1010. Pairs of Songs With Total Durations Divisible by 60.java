class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] modulo = new int[60];
        int pairs = 0;
        
        for(int t: time){
            pairs += modulo[(60-t%60)%60];
            modulo[t%60]++;
        }
        
        return pairs;
    }
}