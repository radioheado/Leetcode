class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        remainders = [0] * k
        for n in arr:
            remainders[n % k] += 1

        for i in range(1, k // 2 + 1):
            # Special case 1: k is even
            if i == k - i and remainders[i] % 2 != 0:
                return False

            if remainders[i] != remainders[k - i]:
                return False

        # Special case 2: numbers have a remainder of 0 should be even total
        return remainders[0] % 2 == 0