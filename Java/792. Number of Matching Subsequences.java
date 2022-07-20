class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<String>[] buckets = new ArrayList[26];
        for (int i=0; i<26; i++) {
            buckets[i] = new ArrayList<String>();
        }
        
        for (String word: words) {
            buckets[word.charAt(0) - 'a'].add(word.substring(1));
        }
        
        int count = 0;
        for (char c: s.toCharArray()) {
            List<String> old = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();
            
            for (String suffix: old) {
                if (suffix == "") {
                    count++;
                } else {
                    buckets[suffix.charAt(0) - 'a'].add(suffix.substring(1));
                }
            }
            old.clear();
        }
        
        return count;
    }
}