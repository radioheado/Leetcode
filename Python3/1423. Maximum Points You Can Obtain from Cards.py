class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        right, left = 0, k-1
        k_sum = 0
        N = len(cardPoints)
        if N == k:
            return sum(cardPoints)
        
        for i in range(k):
            k_sum += cardPoints[i]
        ans = k_sum
        
        while left >= 0:
            #print("left = %d, right = %d, sum = %d" %(cardPoints[left], cardPoints[right], k_sum))
            right -= 1
            k_sum = k_sum - cardPoints[left] + cardPoints[right]
            ans = max(ans, k_sum)
            left -= 1
            
        #print("left = %d, right = %d, sum = %d" %(cardPoints[left], cardPoints[right], k_sum))    
            
        #ans = max(ans, k_sum - cardPoints[0] + cardPoints[right])
        return ans