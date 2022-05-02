class Solution {
    public int[] findPermutation(String s) {
        int n = s.length()+1;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int j = 0;
        
        for (int i=1; i<n; i++) {
            if (s.charAt(i-1) == 'I') {
                stack.push(i);
                while (!stack.isEmpty()) {
                    ans[j++] = stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        
        stack.push(n);
        while (!stack.isEmpty()) {
            ans[j++] = stack.pop();
        } 
        
        return ans;
    }
}