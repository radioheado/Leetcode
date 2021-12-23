class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        for(int i=1; i<strs.length; i++){
            String cur = strs[i];
            int lc = strs[i].length();
            
            prefix = prefix.substring(0, Math.min(lc, prefix.length()));
            //System.out.println(prefix);
            
            int lp = prefix.length();
            
            for(int j=0; j<lp; j++){
                if(cur.charAt(j) != prefix.charAt(j)){
                    //System.out.println(j);
                    prefix = prefix.substring(0, j);
                    break;
                }
                
                if(prefix.length() == 0){
                    break;
                }
            }
            
        }
        
        return prefix;
    }
}