class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        
        // delete leading whitespaces
        s = s.trim();
        
        // return 0 if s is an empty string
        if(s.isEmpty()){
            return 0;
        }
        
        // check if the current leading char is "-" or "+"
        if(s.startsWith("-")){
            sign = -1;
            s = s.substring(1);
        }else if(s.startsWith("+")){
            s = s.substring(1);
        }
        
        //System.out.println(s);
        
        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);
            if(!Character.isDigit(chr)){
                break;
            }
            
            int c = Character.getNumericValue(chr);
            if(ans >= (Math.pow(2,31)-c)/10 && sign == 1){
                return (int)(Math.pow(2,31)-1);
            }
            else if(ans > (Math.pow(2,31)-c)/10 && sign == -1){
                return (int)(-Math.pow(2,31));
            }
            else{
                ans = ans*10 + c;
            }
        }
        
        return sign*ans;
    }
}


            
            