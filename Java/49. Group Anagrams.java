class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> patterns = new HashMap<String, List>();
        
        for(int i=0; i<strs.length; i++){
            
            char[] arrayCh=strs[i].toCharArray();
            Arrays.sort(arrayCh);
            String sortedStr=new String(arrayCh); 
            
            if(!patterns.containsKey(sortedStr)){
                patterns.put(sortedStr, new ArrayList());
            }
            
            patterns.get(sortedStr).add(strs[i]);
        }
        
        return new ArrayList(patterns.values());
    }
}