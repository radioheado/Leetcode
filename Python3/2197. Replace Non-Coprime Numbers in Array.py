class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        stack = []
        for num in nums:
            cur = num
            while stack:
                g = gcd(cur, stack[-1])
                if g == 1:
                    break

                cur = (stack.pop() // g) * cur

            stack.append(cur)

        return stack