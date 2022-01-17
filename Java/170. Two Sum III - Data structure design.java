class TwoSum {
    
    Map<Integer, Integer> nums;
    
    public TwoSum() {
        nums = new HashMap<>();
    }
    
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0)+1);
    }
    
    public boolean find(int value) {
        for(Integer num: nums.keySet()){
            if(nums.containsKey(value-num)){
                if(value-num == num){
                    if(nums.get(num) >= 2){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */