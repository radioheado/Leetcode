class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int p2 = 0;
        
        for (int p1=0; p1<pushed.length; p1++) {
            stack.push(pushed[p1]);
            while(!stack.isEmpty() && stack.peek() == popped[p2]) {
                p2++;
                stack.pop();
            }
        }
        
        return p2 == popped.length;
    }
}