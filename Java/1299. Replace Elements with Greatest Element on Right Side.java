class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int m = arr[n-1];
        arr[n-1] = -1;
        
        for(int i=n-2; i>=0; i--){
            int temp = arr[i];
            arr[i] = m;
            m = Math.max(m, temp);
        }
        
        return arr;
    }
}