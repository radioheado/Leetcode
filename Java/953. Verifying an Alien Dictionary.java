class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> mapping = new HashMap<>();
        
        for(int i=0; i<order.length(); i++){
            mapping.put(order.charAt(i), i);
        }
        
        for(int i=1; i<words.length; i++){
            String prev = words[i-1];
            String cur = words[i];
            
            for(int j=0; j<prev.length(); j++){
                if(j >= cur.length()){
                    return false;
                }
                
                if(prev.charAt(j) != cur.charAt(j)){
                    if(mapping.get(prev.charAt(j)) > mapping.get(cur.charAt(j))){
                        return false;
                    }
                    break;
                }
            }
        }
        
        return true;
    }
}