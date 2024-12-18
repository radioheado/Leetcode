class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        ans = [p for p in prices]
        stack = deque()

        for j, p in enumerate(prices):
            while stack and prices[stack[-1]] >= p:
                i = stack.pop()
                ans[i] = prices[i] - p
            stack.append(j)
        
        return ans