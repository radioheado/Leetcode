class LockingTree {

    private int[] parents;
    private Map<Integer, List<Integer>> tree;
    private Map<Integer, Integer> locked;

    public LockingTree(int[] parent) {
        parents = parent;
        tree = new HashMap();
        locked = new HashMap();
        for (int i=0; i<parent.length; i++) {
            if (parent[i] != -1) {
                tree.computeIfAbsent(parent[i], value -> new ArrayList()).add(i);
            }
        }
    }
    
    public boolean lock(int num, int user) {
        if (locked.containsKey(num)) {
            return false;
        }
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if (!locked.containsKey(num) || locked.get(num) != user) {
            return false;
        }
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        int cur = num;
        // check num's parents
        while (cur != -1) {
            if (locked.containsKey(cur)) {
                return false;
            }
            cur = parents[cur];
        }

        Stack<Integer> stack = new Stack();
        stack.push(num);
        List<Integer> des = new ArrayList();
        
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (tree.containsKey(cur)) {
                for (int child: tree.get(cur)) {
                    if (locked.containsKey(child)) {
                        des.add(child);
                    }
                    stack.push(child);
                }
            }
            
        }

        if (!des.isEmpty()) {
            locked.put(num, user);
            
            for (int child: des) {
                locked.remove(child);
            }

            return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */