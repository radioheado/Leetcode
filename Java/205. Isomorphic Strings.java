class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            char val = t.charAt(i);
            
            /* if s[i] is mapped */
            if(mapping.containsKey(key)){
                if(mapping.get(key) == val){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(seen.contains(val)){
                    return false;
                }
                mapping.put(key, val);
                seen.add(val);
            }
        }
        
        return true;
    }
}