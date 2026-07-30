class Solution:
    def maxProduct(self, n: int) -> int:
        first = second = -1
        while n:
            n, rem = divmod(n, 10)
            if rem >= first:
                second = first
                first = rem
            elif rem > second:
                second = rem
        
        return first * second