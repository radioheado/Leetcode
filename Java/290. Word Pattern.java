class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap mapping = new HashMap();
        
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        
        for(Integer i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            
            if(!mapping.containsKey(c)){
                mapping.put(c, i);
            }
            
            if(!mapping.containsKey(word)){
                mapping.put(word, i);
            }
            
            if(mapping.get(c) != mapping.get(word)){
                return false;
            }
        
        }
        
        return true;
    }
}