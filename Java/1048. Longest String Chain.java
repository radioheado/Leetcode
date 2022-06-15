class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int longest = 1;
        
        for (String word: words) {
            int cur = 1;
            for (int i=0; i<word.length(); i++) {
                StringBuilder pred = new StringBuilder(word);
                pred.deleteCharAt(i);
                int prev = dp.getOrDefault(pred.toString(), 0);
                cur = Math.max(cur, prev+1);
            }
            dp.put(word, cur);
            longest = Math.max(longest, cur);
        }
        
        return longest;
    }
}