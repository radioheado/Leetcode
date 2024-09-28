class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for (String w: words) {
            root.insert(w);
        }

        int[] ans = new int[words.length];
        int i = 0;
        for (String w: words) {
            ans[i++] = root.prefix(w);
        }

        return ans;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String s) {
        TrieNode node = root;
        for (char c: s.toCharArray()) {
            if (node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.count++;
        }
    }

    int prefix(String s) {
        TrieNode node = root;
        int ans = 0;
        for (char c: s.toCharArray()) {
            node = node.children.get(c);
            ans += node.count;
        }
        return ans;
    }
}