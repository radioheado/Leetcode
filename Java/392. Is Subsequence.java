class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }
        
        if(s.isEmpty()) {
            return true;
        }
        
        int p1 = 0;
        for(char c: t.toCharArray()) {
            if(c == s.charAt(p1)) {
                p1++;
            }
            if(p1 == s.length()) {
                return true;
            }
        }
        
        return false;
    }
}