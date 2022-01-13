class MyHashMap {
    private int range;
    private List<Bucket> buckets;

    public MyHashMap() {
        this.range = 2069;
        this.buckets = new ArrayList<Bucket>();
        for(int i=0; i<this.range; i++){
            this.buckets.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int index = key % this.range;
        this.buckets.get(index).insert(key, value);
    }
    
    public int get(int key) {
        int index = key % this.range;
        return this.buckets.get(index).search(key);
    }
    
    public void remove(int key) {
        int index = key % this.range;
        this.buckets.get(index).delete(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    // search a key value pair
    public Integer search(Integer key){
        for(Pair<Integer, Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                return pair.second;
            }
        }
        return -1;
    }
    
    // insert a key value pair or update the value
    public void insert(Integer key, Integer val){
        boolean found = false;
        for(Pair<Integer, Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                pair.second = val;
                found = true;
                break;
            }
        }
        if(!found){
            this.bucket.add(new Pair<Integer, Integer>(key, val));
        }
    }
    
    // delete a key value pair
    public void delete(Integer key){
        for(Pair<Integer, Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class Pair<U, V> {
    public U first;
    public V second;
    
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}