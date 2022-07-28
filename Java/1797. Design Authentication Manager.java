class AuthenticationManager {
    private Map<String, Integer> tokens;
    private int time;

    public AuthenticationManager(int timeToLive) {
        tokens = new HashMap();
        time = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + time);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (tokens.getOrDefault(tokenId, 0) > currentTime) {
            tokens.put(tokenId, currentTime + time);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int t: tokens.values()) {
            if (t > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */