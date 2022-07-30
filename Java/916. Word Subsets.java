class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] sets = new int[26];
        Arrays.fill(sets, 0);
        for (String w: words2) {
            int[] temp = count(w);
            for (int i=0; i<26; i++) {
                sets[i] = Math.max(sets[i], temp[i]);
            }
        }
        
        List<String> ans = new ArrayList();
        for (String w: words1) {
            int[] temp = count(w);
            boolean flag = true;
            
            for (int i=0; i<26; i++) {
                if (temp[i] < sets[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)   ans.add(w);
        }
        
        return ans;
    }
    
    private int[] count(String w) {
        int[] ans = new int[26];
        Arrays.fill(ans, 0);
        for (char c: w.toCharArray()) {
            ans[c-'a']++;
        }
        return ans;
    }
}