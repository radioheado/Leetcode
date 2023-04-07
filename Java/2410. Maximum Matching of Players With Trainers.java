class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = 0, ans = 0;
        for (int t: trainers) {
            if (players[p] <= t) {
                ans++;
                p++;
            }

            if (p >= players.length) {
                break;
            }
        }

        return ans;
    }
}