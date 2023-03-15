class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        N = len(primes)
        ptr = [0] * N
        nums = [1]

        for _ in range(n - 1):
            next_num = inf

            # index, prime number
            for i, p in zip(ptr, primes):
                next_num = min(next_num, nums[i] * p)

            for i, p in enumerate(ptr):
                if nums[p] * primes[i] == next_num:
                    ptr[i] += 1

            nums.append(next_num)
        
        return nums[-1]