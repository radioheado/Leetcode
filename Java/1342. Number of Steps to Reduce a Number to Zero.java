class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        
        int bit = 1, steps = 0;
        
        while (num > 0) {
            if ((num & bit) == 1) {
                steps += 2;
            } else {
                steps++;
            }
            
            num >>= 1;
        }
        
        return --steps;
    }
}