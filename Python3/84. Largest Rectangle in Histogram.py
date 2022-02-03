class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        stack = deque([-1])
        area = 0
        
        for i, h in enumerate(heights):
            while stack[-1] != -1 and heights[stack[-1]] >= h:
                backwards_height = heights[stack.pop()]
                backwards_width = i - stack[-1] - 1
                area = max(area, backwards_height * backwards_width)
            stack.append(i)
            
        # deal with the remaining small heights
        while stack[-1] != -1:
            backwards_height = heights[stack.pop()]
            backwards_width = len(heights) - stack[-1] - 1
            area = max(area, backwards_height * backwards_width)
            
        return area