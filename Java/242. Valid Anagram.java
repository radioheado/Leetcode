class Solution {
    public boolean isAnagram(String s, String t) {
        
        // different lengths
        if(s.length() != t.length()){
            return false;
        }
        
        char[] chars = new char[26];
        
        // count the number of each char
        for(int i=0; i<s.length(); i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        
        for(int i: chars){
            if(i != 0){
                return false;
            }
        }
        
        return true;
        
    }
}