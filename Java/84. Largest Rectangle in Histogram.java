class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        
        for(int i=0; i<heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            area = Math.max(area, height * width);
        }
        
        return area;
    }
}