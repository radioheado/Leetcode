class Solution {
    
    Map<String, Integer> wordCounts;
    int total_len, W, S, diff;
    List<Integer> ans;
    
    public List<Integer> findSubstring(String s, String[] words) {
        wordCounts = new HashMap();
        for (String w: words) {
            wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1);
        }
        System.out.println(wordCounts);
        S = s.length();
        W = words.length;
        diff = words[0].length();
        total_len = W * diff;
        ans = new ArrayList();
        
        for (int left=0; left<diff; left++) {
            window(left, s);
        }
        
        return ans;
    }
    
    private void window(int left, String s) {
        int used = 0;
        Map<String, Integer> curs = new HashMap();
        
        for (int right = left; right <= S - diff; right+=diff) {
            String sub = s.substring(right, right + diff);
            // start over
            if (!wordCounts.containsKey(sub)) {
                curs.clear();
                used = 0;
                left = right + diff;
            } else {
                curs.put(sub, curs.getOrDefault(sub, 0) + 1);
                used++;
                
                while (right - left > total_len || curs.get(sub) > wordCounts.get(sub)) {
                    String leftWord = s.substring(left, left + diff);
                    left += diff;
                    curs.put(leftWord, curs.get(leftWord) - 1);
                    used--;
                }
                //System.out.println(curs);
                if (used == W) {
                    ans.add(left);
                }
            }
        }
    }
}