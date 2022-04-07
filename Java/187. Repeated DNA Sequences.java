class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> patterns = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        for (int i=9; i<s.length(); i++) {
            String sub = s.substring(i-9, i+1);
            if (!patterns.containsKey(sub)) {
                patterns.put(sub, 1);
            } else {
                if (patterns.get(sub) == 1) {
                    ans.add(sub);
                    patterns.put(sub, 2);
                }
            }
        }
        
        return ans;
    }
}