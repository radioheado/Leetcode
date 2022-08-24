class Solution {
    private Power4 p = new Power4();
    public boolean isPowerOfFour(int n) {
        return p.nums.contains(n);
        
    }
}

class Power4 {
    public List<Integer> nums = new ArrayList();
    
    Power4() {
        int last = 1;
        nums.add(last);
        
        for (int i=1; i<16; i++) {
            last *= 4;
            nums.add(last);
        }
    }
}