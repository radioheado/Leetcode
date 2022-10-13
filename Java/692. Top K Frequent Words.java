class Solution {
    private int k;
    private List<String> ans;
    
    class Trie {
        Trie[] children;
        boolean isWord;
        
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
    
    private void add(Trie root, String word) {
        Trie cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    private void get(Trie root, String prefix) {
        if (k == 0) {
            return;
        }
        if (root.isWord) {
            k--;
            ans.add(prefix);
        }
        for (int i=0; i<26; i++) {
            if (root.children[i] != null) {
                get(root.children[i], prefix + (char)(i + 'a'));
            }
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        this.k = k;
        ans = new ArrayList();
        int n = words.length;
        Trie[] buckets = new Trie[n + 1];
        Map<String, Integer> count = new HashMap();
        
        /* create a map to keep track of (word, frequency) */
        for (String w: words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        /* add each word to its frequency bucket */
        for (var entry: count.entrySet()) {
            /* current bucket doesn't have a Trie, create it first */
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new Trie();
            }
            /* add the word to this Trie */
            add(buckets[entry.getValue()], entry.getKey());
        }
        
        /* read k words from the highest frequency, and lexicographically smallest */
        for (int i=n; i>0; i--) {
            /* if this bucket has a Trie, read words here */
            if (buckets[i] != null) {
                get(buckets[i], "");
            }
            /* read enough words */
            if (this.k == 0) {
                break;
            }
        }
        
        return ans;
    }
}