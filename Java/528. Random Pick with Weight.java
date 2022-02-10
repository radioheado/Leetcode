class Solution {
    int[] array;
    public Solution(int[] w) {
        array = new int[w.length];
        int pre = 0;
        for(int i=0; i<w.length; i++){
            pre += w[i];
            array[i] = pre;
        }
    }
    
    public int pickIndex() {
        double target = array[array.length-1] * Math.random();
        int left = 0, right = array.length-1;
        while(left < right){
            int mid = (right-left)/2 + left;
            if(target > array[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */