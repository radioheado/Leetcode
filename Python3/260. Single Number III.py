class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        bitmask = 0
        for n in nums:
            bitmask ^= n

        diff = bitmask & (-bitmask)

        x = 0
        for n in nums:
            # The new bitmask will only contain numbers that
            # has 1 at the given position.
            # Since all qualified numbers appear twice but x,
            # the xor of these numbers will eventually be x
            if n & diff:
                x ^= n

        return [x, bitmask ^ x]