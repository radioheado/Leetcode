class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int cur = 1;
        
        while(cur < temperatures.length){
            int top = stack.peek();
            while(temperatures[cur] > temperatures[top]){
                ans[top] = cur-top;
                stack.pop();
                
                if(!stack.empty()){
                    top = stack.peek();
                }else{
                    break;
                }
                  
            }
            
            stack.push(cur);
            cur += 1;
        }
        
        return ans;
    }
}