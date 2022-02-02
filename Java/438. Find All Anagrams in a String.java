class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(p.length() > s.length()){
            return ans;
        }
        
        int[] chars1 = new int[26];
        for(int i=0; i<p.length(); i++){
            chars1[p.charAt(i) - 'a']++;
        }
        
        int diff = p.length();
        int[] chars2 = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            chars2[c-'a']++;
            if(i >= diff){
                chars2[s.charAt(i-diff) - 'a']--;
            }
            
            if(Arrays.equals(chars1, chars2)){
                ans.add(i - diff + 1);
            }
        }
        return ans;
    }
    
}