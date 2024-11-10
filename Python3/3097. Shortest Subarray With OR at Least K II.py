class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        bit_counts = [0] * 32

        def updateBitCounts(num: int, delta: int) -> None:
            for pos in range(32):
                if num & (1 << pos):
                    bit_counts[pos] += delta

        def convertBitsToNum() -> int:
            res = 0
            for pos in range(32):
                if bit_counts[pos]:
                    res |= 1 << pos
            return res

        ans = inf
        s = e = 0
        while e < len(nums):
            # Add current number to the window
            updateBitCounts(nums[e], 1)

            while s <= e and convertBitsToNum() >= k:
                ans = min(ans, e - s + 1)
                updateBitCounts(nums[s], -1)
                s += 1

            e += 1

        return -1 if ans == inf else ans