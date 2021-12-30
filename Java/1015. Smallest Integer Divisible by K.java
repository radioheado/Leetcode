class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem = 0;
        
        for(int i=1; i<k+1; i++){
            rem = (rem*10+1) % k;
            if(rem == 0){
                return i;
            }
        }
        
        return -1;
    }
}