class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while(!seen.contains(n)){
            seen.add(n);
            int sum = 0;
            
            /* calculate the sum of the squares of each digit
             * using modulo instead of reading strings
             */
            while(n > 0){
                sum += (n%10)*(n%10);
                n /= 10;
            }
            
            if(sum == 1){
                return true;
            }
            
            n = sum;
        }
        
        return false;
    }
}