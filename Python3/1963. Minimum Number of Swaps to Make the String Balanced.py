class Solution:
    def minSwaps(self, s: str) -> int:
        l, r = 0, len(s) - 1
        ans = count = 0

        while l < r:
            if s[l] == '[':
                count += 1
            else:
                count -= 1

            # we have more closing brackets now
            if count < 0:
                while r > l and s[r] != '[':
                    r -= 1
                # reach to an opening bracket, swap
                ans += 1
                count += 2
                r -= 1

            l += 1

        return ans   