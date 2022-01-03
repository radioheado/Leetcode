class Solution {
    public int fib(int n) {
        
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        
        int first = 0;
        int second = 1;
        
        for(int i=0; i<n-1; i++){
            int temp = first+second;
            first = second;
            second = temp;
        }
        
        return second;
    }
}