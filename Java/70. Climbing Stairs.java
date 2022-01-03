class Solution {
    public int climbStairs(int n) {
        // ways[n] = ways[n-1] + ways[n-2]
        int first = 1;
        int second = 2;
        
        for(int i=1; i<n-1; i++){
            int temp = first+second;
            first = second;
            second = temp;
        }
        
        return n == 1 ? first : second;
    }
}