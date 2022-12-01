class FileSystem {
    Map<String, Integer> trie;

    public FileSystem() {
        this.trie = new HashMap<String, Integer>();
    }
    
    public boolean createPath(String path, int value) {
        if (path.isEmpty() || (path.length() == 1 && path.equals("/")) ||
            this.trie.containsKey(path)) {
            return false;
        }
        
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        
        if (parent.length() > 1 && !this.trie.containsKey(parent)) {
            return false;
        }
        
        this.trie.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return this.trie.getOrDefault(path, -1);
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

