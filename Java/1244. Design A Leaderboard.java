class Leaderboard {
    Map<Integer, Integer> players;
    TreeMap<Integer, Integer> scores;

    public Leaderboard() {
        this.players = new HashMap();
        this.scores = new TreeMap(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!this.players.containsKey(playerId)) {
            this.players.put(playerId, score);
            this.scores.put(score, this.scores.getOrDefault(score, 0) + 1);
        } else {
            int cur = this.players.get(playerId);
            int count = this.scores.get(cur);

            if (count == 1) {
                this.scores.remove(cur);
            } else {
                this.scores.put(cur, count - 1);
            }

            this.players.put(playerId, cur + score);
            this.scores.put(cur + score, this.scores.getOrDefault(cur + score, 0) + 1);
        }
    }
    
    public int top(int K) {
        int cnt = 0, ans = 0;
        for (int score: this.scores.keySet()) {
            int count = this.scores.get(score);
            for (int c = 0; c < count; c++) {
                ans += score;
                cnt++;
                if (cnt == K) {
                    return ans;
                }
            }
            if (cnt == K) {
                return ans;
            }
        }
        return ans;
    }
    
    public void reset(int playerId) {
        int score = this.players.get(playerId);
        int count = this.scores.get(score);
        if (count == 1) {
            this.scores.remove(score);
        } else {
            this.scores.put(score, count - 1);
        }
        this.players.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */