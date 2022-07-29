class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        if (pattern.length() == 1) {
            for (String w: words) {
                ans.add(w);
            }
            return ans;
        }
        
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();
        int l = pattern.length();
        char c1, c2;
        
        for (String w: words) {
            m1.clear();
            m2.clear();
            for (int i=0; i<l; i++) {
                c1 = w.charAt(i);
                c2 = pattern.charAt(i);
                if (!m1.containsKey(c1))  m1.put(c1, c2);
                if (!m2.containsKey(c2))  m2.put(c2, c1);
                if (m1.get(c1) != c2 || m2.get(c2) != c1) {
                    break;
                }
                
                if (i == l-1)   ans.add(w);
            }
        }
        
        return ans;
    }
}