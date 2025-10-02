class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles, empty = numBottles;
        while (empty >= numExchange) {
            ans++;
            empty -= numExchange - 1;
            numExchange++;            
        }
        return ans;
    }
}