class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        
        def backtrack(cur = [], counter = Counter(nums)):
            if len(cur) == len(nums):
                ans.append(cur[:])
                
            for num in counter.keys():
                if counter[num] > 0:
                    counter[num] -= 1
                    cur.append(num)
                    backtrack(cur, counter)
                    counter[num] += 1
                    cur.pop()
                
        backtrack()
        return ans