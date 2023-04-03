class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort(reverse = True)
        ans = []

        def find(s: int) -> int:
            l, r = 0, len(potions) - 1
            while l <= r:
                m = (r - l) // 2 + l
                # m cannot be included
                if potions[m] * s < success:
                    r = m - 1
                else:
                    l = m + 1
            return l


        for s in spells:
            ans.append(find(s))
            
        return ans