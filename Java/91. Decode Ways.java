class Solution {
    public int numDecodings(String s) {
        char prev = s.charAt(0);
        
        /* special case */
        if (prev == '0') {
            return 0;
        }
        
        int avoid = 1, using = 1;
        for (int i=1; i<s.length(); i++) {
            char one = s.charAt(i);
            int two = Integer.parseInt(s.substring(i-1, i+1));
            //System.out.println("single = " + one + ", both = " + two);
            /* one or two are both invalid */
            if (one == '0' && (two > 26 || two < 10)) {
                return 0;
            }
            
            /* one is invalid, we must use cur with the previous char
               which means we have to avoid the previous char in the last step
             */
            else if (one == '0') {
                using = avoid;
            }
            
            /* two is invalid, we must use cur alone
               which means we have to use the previous char in the last step
             */
            else if (two > 26 || two < 10) {
                avoid = using;
            }
            
            /* both are valid, we can either use or avoid the previous char */
            else {
                int temp = avoid + using;
                avoid = using;
                using = temp;
            }
        }
        
        return using;
    }
}