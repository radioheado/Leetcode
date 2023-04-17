class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i : candies){
            max = Math.max(i, max);
        }
        
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i : candies){
            ans.add(i+extraCandies >= max);
        }
        
        return ans;
    }
}