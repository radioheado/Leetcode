class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        nums = [i[1] for i in envelopes]
        sub = [nums[0]]
        L = 1
        
        for n in nums[1:]:
            if n > sub[-1]:
                sub.append(n)
                L += 1
            else:
                sub[bisect_left(sub, n)] = n
        
        return L