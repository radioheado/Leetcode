class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return isValid(rectangles, 0) || isValid(rectangles, 1);
    }

    private boolean isValid(int[][] rectangles, int dim) {
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));
        int cuts = 0, farthest = rectangles[0][dim + 2];
        for (int i = 1; i < rectangles.length; i++) {
            if (farthest <= rectangles[i][dim]) {
                cuts++;
            }
            farthest = Math.max(farthest, rectangles[i][dim + 2]);
        }
        return cuts >= 2;
    }
}