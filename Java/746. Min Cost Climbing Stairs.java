class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int cost1 = 0, cost2 = 0;
        
        for(int i=2; i<cost.length+1; i++){
            int temp = cost2;
            cost2 = Math.min(cost1 + cost[i-2], cost2 + cost[i-1]);
            cost1 = temp;
        }
        
        return cost2;
    }
}