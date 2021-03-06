class Solution {
    public int tribonacci(int n) {
        if(n < 3){
            return n == 0 ? 0 : 1;
        }
        
        int n1 = 0, n2 = 1, n3 = 1;
        for(int i=0; i<n-2; i++){
            int temp = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = temp;
        }
        
        return n3;
    }
}