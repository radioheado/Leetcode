class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()){
            String temp = new String(s);
            s = t;
            t = temp;
        }
        int len1 = s.length();
        int len2 = t.length();
        
        for(int i=0; i<len1; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(len1 == len2){
                    return(s.substring(i+1).equals(t.substring(i+1)));
                }else{
                    return(s.substring(i).equals(t.substring(i+1)));
                }
            }
        }
        
        return(len1+1==len2);
        
    }
}