class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        
        for(int i=digits.length-1; i>=0; i--){
            // get the carry and remains
            int[] cr = divmod(carry+digits[i]);
            
            // get the carry and update the current index in digits
            carry = cr[0];
            digits[i] = cr[1];
        }
        
        if(carry > 0){
            digits = new int[digits.length+1];
            digits[0] = carry;
        }
        
        return digits;
    }
    
    // a helper function which fulfills the divmod method in Python3
    private int[] divmod(int number){
        int carry = number/10;
        int remain = number%10;
        return new int[] {carry, remain};
    }
}