class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        # The XOR sum of the derived array should be 0
        xor = 0
        for d in derived:
            xor ^= d
        return xor == 0