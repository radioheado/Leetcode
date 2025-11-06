class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        ans = []
        count = Counter()
        occur_num = SortedList()

        for i, n in enumerate(nums):
            if count[n] > 0:
                occur_num.discard((count[n], n))

            count[n] += 1
            occur_num.add((count[n], n))

            if i >= k:
                occ = count[nums[i - k]]
                occur_num.discard((occ, nums[i - k]))
                count[nums[i - k]] -= 1
                if count[nums[i - k]] > 0:
                    occur_num.add((occ - 1, nums[i - k]))
            
            if i >= k - 1:
                ans.append(sum(o * n for o, n in occur_num[-x:]))

        return ans