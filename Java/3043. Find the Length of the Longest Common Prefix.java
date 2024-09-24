class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int a: arr1) {
            root.insert(a);
        }

        int ans = 0;
        for (int a: arr2) {
            ans = Math.max(ans, root.findCommonPrefix(a));
        }
        
        return ans;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[10];
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode node = root;
        String str = Integer.toString(num);
        for (char c: str.toCharArray()) {
            int i = c - '0';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
    }

    int findCommonPrefix(int num) {
        TrieNode node = root;
        String str = Integer.toString(num);
        int ans = 0;

        for (char c: str.toCharArray()) {
            int i = c - '0';
            if (node.children[i] == null) {
                break;
            }
            node = node.children[i];
            ans++;
        }

        return ans;
    }
}