class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        picked = defaultdict(int)
        ans = l = 0

        for r, f in enumerate(fruits):
            picked[f] += 1

            while len(picked) > 2:
                picked[fruits[l]] -= 1
                if picked[fruits[l]] == 0:
                    del picked[fruits[l]]

                l += 1

            ans = max(ans, r - l + 1)

        return ans