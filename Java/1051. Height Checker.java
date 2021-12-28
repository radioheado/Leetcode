class Solution {
    public int heightChecker(int[] heights) {
        System.out.println(Arrays.toString(heights));
        int[] copy = new int[heights.length];
        
        for(int i=0; i<heights.length; i++){
            copy[i] = heights[i];
        }
        
        Arrays.sort(copy);
        //System.out.println(Arrays.toString(heights));
        
        int res = 0;
        
        for(int i=0; i<heights.length; i++){
            if(copy[i] != heights[i]){
                res++;
            }
        }
        
        return res;
    }
}