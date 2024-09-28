class Solution {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        for (String w: words) {
            root.insert(w);
        }

        String ans = "";
        for (String w: words) {
            if (ans.length() > w.length()) {
                continue;
            }
            String pref = root.prefix(w);
            if (pref.length() > ans.length()) {
                ans = pref;
            } else if (pref.length() == ans.length() && pref.compareTo(ans) < 0) {
                ans = pref;
            }
        }
        return ans;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String w) {
        TrieNode node = root;
        for (char c: w.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isWord = true;
    }

    String prefix(String w) {
        TrieNode node = root;
        for (char c: w.toCharArray()) {
            int i = c - 'a';
            node = node.children[i];
            if (!node.isWord) {
                return "";
            }
        }
        return w;
    }
}