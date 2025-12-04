class Solution {
    public int countCollisions(String directions) {
        int n = directions.length(), l = 0, r = n - 1;
        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= l && directions.charAt(r) == 'R') {
            r--;
        }

        int ans = 0;
        while (l <= r) {
            if (directions.charAt(l) != 'S') {
                ans++;
            }
            l++;
        }
        return ans;
    }
}