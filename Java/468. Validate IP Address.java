class Solution {
    public String validIPAddress(String queryIP) {
        if(validIPv4(queryIP))  return "IPv4";
        else if(validIPv6(queryIP)) return "IPv6";
        else    return "Neither";
    }
    
    private Boolean validIPv4(String ip){
        // . is an escape character
        String[] nums = ip.split("\\.", -1);
        /*for(String x: nums){
            System.out.println(x);
        }*/
        
        if(nums.length != 4){
            return false;
        }
                
        for(String x: nums){
            // length should be less than or equal to 3 but not 0
            if(x.length() > 3 || x.length() < 1)    return false;
            
            
            // no leading zeros for string length larger than 1
            if(x.length() > 1 && x.charAt(0) == '0')   return false;
            
            
            // if i contains nondigits
            for(char ch: x.toCharArray()){
                if(!Character.isDigit(ch))  return false;
            }
            
            // if i is out of the range [0, 255]
            if(Integer.parseInt(x) > 255)   return false;
            
        }
        
        return true;
    }
    
    
    private Boolean validIPv6(String ip){
        String[] nums = ip.split(":", -1);
        // s should have exactly 8 sub addresses
        if(nums.length != 8)    return false;
        
        String hexs = "0123456789abcdefABCDEF";
        
        for(String x: nums){
            //System.out.println(x);
            
            // 1 <= length <= 4
            if(x.length() > 4 || x.length() == 0)   return false;
            
            for(Character ch: x.toCharArray()){
                if(hexs.indexOf(ch) == -1)  return false;
            }
        }
        
        return true;
    }
}