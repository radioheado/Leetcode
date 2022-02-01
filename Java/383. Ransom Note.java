class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // not enough total chars in magazine
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        
        int[] chars = new int[26];
        for(int i=0; i<magazine.length(); i++){
            chars[magazine.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<ransomNote.length(); i++){
            if(chars[ransomNote.charAt(i) - 'a'] <= 0){
                return false;
            }
            chars[ransomNote.charAt(i) - 'a']--;
        }
        
        return true;
    }
}