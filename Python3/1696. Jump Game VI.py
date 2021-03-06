class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        L = len(nums)
        score = [0] * L
        # edge case
        score[0] = nums[0]
        dq = deque()
        dq.append(0)
        
        for i in range(1, L):
            # pop the indices that won't be used anymore
            while dq and dq[0] < i-k:
                dq.popleft()
            score[i] = score[dq[0]] + nums[i]
            
            # pop the smaller values because they won't be used either
            while dq and score[i] >= score[dq[-1]]:
                dq.pop()
            dq.append(i)
        
        return score[-1]