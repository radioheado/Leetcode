class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int left = (ax1 - ax2) * (ay1 - ay2);
        int right = (bx1 - bx2) * (by1 - by2);
        int dx = Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0);
        int dy = Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);
        return left + right - dx * dy;
    }
}