class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();
    int size;

    public RandomizedSet() {
        dict = new HashMap();
        list = new ArrayList();
        size = 0;
    }
    
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        
        dict.put(val, size++);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        
        int idx = dict.get(val);
        int last = list.get(--size);
        
        // swap the last element and val
        dict.put(last, idx);
        list.set(idx, last);
        
        // remove val from dict and list
        dict.remove(val);
        list.remove(size);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */