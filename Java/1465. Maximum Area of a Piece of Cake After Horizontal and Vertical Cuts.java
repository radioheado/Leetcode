class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts); 
        int m = horizontalCuts.length, n = verticalCuts.length;
        
        long h_diff = Math.max(horizontalCuts[0], h - horizontalCuts[m-1]), 
             v_diff = Math.max(verticalCuts[0], w - verticalCuts[n-1]);
        
        for (int i=1; i<horizontalCuts.length; i++) {
            h_diff = Math.max(h_diff, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        
        for (int i=1; i<verticalCuts.length; i++) {
            v_diff = Math.max(v_diff, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        return (int) ((h_diff * v_diff) % 1000000007);
    }
}