class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lr = 0, ans = 0;
        for (char move: moves.toCharArray()) {
            if (move == '_') {
                ans++;
            } else if (move == 'L') {
                lr++;
            } else {
                lr--;
            }
        }
        return ans + Math.abs(lr);
    }
}