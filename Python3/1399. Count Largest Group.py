class Solution:
    def countLargestGroup(self, n: int) -> int:
        sum_set = Counter()
        max_size = 0

        for num in range(1, n + 1):
            digit_sum = 0
            while num:
                digit_sum += num % 10
                num //= 10
            sum_set[digit_sum] += 1
            max_size = max(max_size, sum_set[digit_sum])
        
        ans = 0
        for v in sum_set.values():
            if v == max_size:
                ans += 1

        return ans     