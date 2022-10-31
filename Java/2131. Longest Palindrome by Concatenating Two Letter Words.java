class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> same = new HashMap();
        Map<String, Integer> comp = new HashMap();
        int ans = 0;
        
        for (String w: words) {
            String rev = reverse(w);
            
            if (rev.equals(w)) {
                
                if (same.getOrDefault(w, 0) == 1) {
                    ans += 4;
                    same.put(w, same.get(w) - 1);
                } else {
                    same.put(w, same.getOrDefault(w, 0) + 1);
                }
                
            } else {
                
                if (comp.getOrDefault(rev, 0) > 0) {
                    ans += 4;
                    comp.put(rev, comp.get(rev) - 1);
                } else {
                    comp.put(w, comp.getOrDefault(w, 0) + 1);
                }
            }
        }
        
        for (int w: same.values()) {
            if (w > 0) {
                return ans + 2;
            }
        }
        
        return ans;
    }
    
    private String reverse(String word) {
        StringBuilder rev = new StringBuilder();
        for (char c: word.toCharArray()) {
            rev.append(c);
        }
        rev.reverse();
        return rev.toString();
    }
}