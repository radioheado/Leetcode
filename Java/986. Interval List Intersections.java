class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;
        
        while(p1 < firstList.length && p2 < secondList.length) {
            int left = Math.max(firstList[p1][0], secondList[p2][0]);
            int right = Math.min(firstList[p1][1], secondList[p2][1]);
            
            if(left <= right) {
                ans.add(new int[] {left, right});
            }
            
            if(firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        
        int[][] res = new int[ans.size()][];
        int i = 0;
        
        for(int[] a: ans) {
            res[i++] = a;
        }
        
        return res;
    }
}