class Solution {
    public int findComplement(int num) {
        int helper = num, bit = 1;
        
        while(helper > 0){
            num ^= bit;
            bit <<= 1;
            helper >>= 1;
        }
        
        return num;
    }
}