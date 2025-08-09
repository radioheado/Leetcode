class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        ans = 0
        for f in fruits:
            for i, b in enumerate(baskets):
                if f <= b:
                    baskets[i] = 0
                    ans -= 1
                    break

            ans += 1

        return ans