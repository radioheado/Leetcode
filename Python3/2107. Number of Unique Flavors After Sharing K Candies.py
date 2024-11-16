class Solution:
    def shareCandies(self, candies: List[int], k: int) -> int:
        flavors = Counter(candies)
        total_flavors = len(flavors)

        # Special case
        if k == 0:
            return total_flavors

        count = l = ans = 0

        for r, c in enumerate(candies):
            flavors[c] -= 1

            if flavors[c] == 0:
                count += 1

            if r - l + 1 == k:
                ans = max(ans, total_flavors - count)
                flavors[candies[l]] += 1
                if flavors[candies[l]] == 1:
                    count -= 1
                l += 1

        return ans