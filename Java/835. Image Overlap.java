class Solution {
    private int ans = 0;
    
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0;
        Map<Pair<Integer, Integer>, Integer> count = new HashMap();
        
        List<int[]> ones1 = findOnes(img1);
        List<int[]> ones2 = findOnes(img2);
        
        for (int[] a: ones1) {
            for (int[] b: ones2) {
                Pair<Integer, Integer> vec = new Pair<>(a[0] - b[0], a[1] - b[1]);
                count.put(vec, count.getOrDefault(vec, 0) + 1);
                ans = Math.max(ans, count.get(vec));
            }
        }
        
        return ans;
    }
    
    private List<int[]> findOnes(int[][] arr) {
        List<int[]> ans = new ArrayList();
        int R = arr.length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < R; c++) {
                if (arr[r][c] == 1) {
                    ans.add(new int[] {r, c});
                }
            }
        }
        return ans;
    }
}