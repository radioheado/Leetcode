class Trie {
    
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.hasKey(c)) {
                cur.put(c, new Node());
            }
            cur = cur.get(c);
        }
        cur.setWord();
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.hasKey(c)) {
                return false;
            }
            cur = cur.get(c);
        }
        return cur.isWord();
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()) {
            if (!cur.hasKey(c)) {
                return false;
            }
            cur = cur.get(c);
        }
        return true;
    }
}

class Node {
    private Node[] nodes;
    private final int R = 26;
    private boolean isWord;
    
    public Node() {
        nodes = new Node[R];
    }
    
    public boolean hasKey(char c) {
        return nodes[c - 'a'] != null;
    }
    
    public Node get(char c) {
        return nodes[c - 'a'];
    }
    
    public void put(char c, Node n) {
        nodes[c - 'a'] = n;
    }
    
    public void setWord() {
        isWord = true;
    }
    
    public boolean isWord() {
        return isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */