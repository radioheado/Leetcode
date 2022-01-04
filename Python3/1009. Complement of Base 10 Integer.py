class Solution:
    def bitwiseComplement(self, n: int) -> int:
        
        if n == 0:
            return 1
        
        record, bit = n, 1
        
        while record:
            n ^= bit
            bit <<= 1
            record >>= 1
            
        return n