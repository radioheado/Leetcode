class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        # Count there are how many numbers between prefix1 and prefix2
        def countSteps(prefix1: int, prefix2: int) -> int:
            steps = 0
            while prefix1 <= n:
                steps += min(n + 1, prefix2) - prefix1
                prefix1 *= 10
                prefix2 *= 10
            return steps

        cur = 1
        k -= 1
        while k:
            steps = countSteps(cur, cur + 1)
            # We haven't reached to the k-th number 
            # in this prefix's subtree. Skip it.
            if steps <= k:
                cur += 1
                k -= steps
            # K-th number falls within this subtree, 
            # move to the next level and decrement k
            else:
                cur *= 10
                k -= 1

        return cur