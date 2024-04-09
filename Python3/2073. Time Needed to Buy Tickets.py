class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        # RULE:
        #       1. people before k-th will need to be counted as min(p, k)
        #       2. people behind k-th will need to be counted as min(p, k - 1)
        ans = 0
        for i, t in enumerate(tickets):
            if i <= k:
                ans += min(t, tickets[k])
            elif i > k:
                ans += min(t, tickets[k] - 1)

        return ans