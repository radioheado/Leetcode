class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        divisors = defaultdict(int)
        ans = 0

        def findDivisors(n: int) -> int:
            if n in divisors:
                return divisors[n]

            count = _sum = 0
            for d in range(1, int(sqrt(n)) + 1):
                if n / d == n // d:
                    if d != n // d:
                        count += 1
                        _sum += n // d
                    count += 1
                    _sum += d

                if count > 4:
                    break

            if count == 4:
                divisors[n] = _sum
                return _sum
            else:
                return 0

        for n in nums:
            ans += findDivisors(n)

        return ans