class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        seen = [False] * 1000
        ans = 0

        for i, n in enumerate(digits):
            if n == 0:
                continue
            
            for j, n2 in enumerate(digits):
                if j == i:
                    continue
                for k, n3 in enumerate(digits):
                    if n3 % 2 or k == i or k == j:
                        continue
                    num = n * 100 + n2 * 10 + n3
                    if not seen[num]:
                        ans += 1
                        seen[num] = True

        return ans