class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0){
            return 1;
        }
        
        int record = n, bit = 1;
        while(record > 0){
            n ^= bit;
            bit <<= 1;
            record >>= 1;
        }
        
        return n;
    }
}