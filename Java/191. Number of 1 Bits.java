public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int dis = 0;
        while(n != 0){
            dis++;
            n &= (n-1);
        }
        return dis;
    }
}