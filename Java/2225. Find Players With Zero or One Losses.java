class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] loses = new int[100001];
        Arrays.fill(loses, -1);
        
        for(int[] m: matches) {
            if (loses[m[0]] == -1) {
                loses[m[0]] = 0;
            }
            if (loses[m[1]] == -1) {
                loses[m[1]] = 1;
            } else {
                loses[m[1]]++;
            }
        }
        
        List<List<Integer>> ans = Arrays.asList(new ArrayList(), new ArrayList());
        
        for (int i=1; i<100001; i++) {
            if (loses[i] == 0) {
                ans.get(0).add(i);
            } else if (loses[i] == 1) {
                ans.get(1).add(i);
            }
        }
        
        return ans;
    }
}