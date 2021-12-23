class Solution {
    public int strStr(String haystack, String needle) {
        
        int ln = needle.length();
        
        if(ln == 0){
            return 0;
        }
            
        int lh = haystack.length();
        
        for(int i=0; i<=lh-ln; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                String sub = haystack.substring(i, i+ln);
                if(sub.equals(needle)){
                    return i;
                }
            }
        }
        
        return -1;
    }
}