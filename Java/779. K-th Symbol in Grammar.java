class Solution {
    public int kthGrammar(int n, int k) {
        // the base case
        if(n == 1){
            return 0;
        }
        
        // recursively call the function to calculate the (n-1)-th digit
        int prev = kthGrammar(n-1, (k+1)/2);
        
        // calculate the current digit
        if(prev == 1){
            if(k%2 == 1){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(k%2 == 1){
                return 0;
            }else{
                return 1;
            }
        }
        
    }
}