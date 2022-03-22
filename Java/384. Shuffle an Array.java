class Solution {
    private int[] array;
    private int[] origin;
    private Random rand = new Random();
    
    private List<Integer> copyArray() {
        List<Integer> newArray = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            newArray.add(array[i]);
        }
        return newArray;
    }
    
    public Solution(int[] nums) {
        array = nums;
        origin = nums.clone();
    }
    
    public int[] reset() {
        array = origin;
        origin = origin.clone();
        return array;
    }
    
    public int[] shuffle() {
        List<Integer> copy = copyArray();
        for (int i=0; i<array.length; i++) {
            int removed = rand.nextInt(copy.size());
            array[i] = copy.get(removed);
            copy.remove(removed);
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */