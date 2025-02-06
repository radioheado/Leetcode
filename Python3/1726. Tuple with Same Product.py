class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        products = defaultdict(int)
        ans = 0

        for i, n1 in enumerate(nums):
            for j, n2 in enumerate(nums[i + 1:], i + 1):
                products[n1 * n2] += 1

        for v in products.values():
            if v > 1:
                ans += 4 * v * (v - 1)

        return ans