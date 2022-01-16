class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> patterns = new HashMap<>();
        
        for(String s: strings){
            String key = getHash(s);
            if(patterns.get(key) == null){
                patterns.put(key, new ArrayList<>());
            }
            patterns.get(key).add(s);
        }
        
        // transfer the values to the result list
        List<List<String>> res = new ArrayList<>();
        
        for(List<String> s: patterns.values()){
            res.add(s);
        }
        
        return res;
    }
    
    private String getHash(String s){
        char[] chars = s.toCharArray();
        
        // shifts that needed to transform the first char into 'a'
        int diff = chars[0];
        
        for(int i=0; i<chars.length; i++){
            chars[i] = shifter(chars[i], diff);
        }
        
        String key = String.valueOf(chars);
        return key;
    }
    
    private char shifter(char c, int diff){
        return (char) ((c-diff+26)%26 + 'a');
    }
}