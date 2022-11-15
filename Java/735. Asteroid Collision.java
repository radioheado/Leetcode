class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int a: asteroids) {
            boolean left = true;
            
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                /* new asteroid crashes the peek, push the new one */
                if (stack.peek() < -a) {
                    stack.pop();
                    continue;
                } 
                /* new asteroid and the peek both explode, don't push */
                else if (stack.peek() == -a) {
                    stack.pop();
                    left = false;
                } 
                /* the peek crashes the new asteroid, don't push */
                else {
                    left = false;
                }
                break;
            } 
            
            if (left) {
                stack.push(a);
            }
        }
        
        int[] ans = new int[stack.size()];
        for (int i=stack.size()-1; i>=0; i--) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}