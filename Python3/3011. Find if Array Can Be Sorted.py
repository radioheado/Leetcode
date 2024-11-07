class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        # [count, min_val, max_val]
        ones = []
        for n in nums:
            one_count = bin(n).count('1')
            # Add a new set
            if not ones or one_count != ones[-1][0]:
                ones.append([one_count, n, n])

            else:
                ones[-1][1] = min(ones[-1][1], n)
                ones[-1][2] = max(ones[-1][2], n)
                
            if len(ones) > 1 and ones[-1][1] < ones[-2][2]:
                return False

        return True