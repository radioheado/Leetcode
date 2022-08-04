class Solution {
    public int mirrorReflection(int p, int q) {
        int y = 0;
        boolean left = true;
        
        while (true) {
            y += q;
            left = !left;
            
            // we hit a corner
            if (y % p == 0) {
                // we hit corner 2
                if (left) {
                    return 2;   
                }
                
                boolean even = (y/p) % 2 == 0;
                return even ? 0 : 1;
            }
        }
    }
}