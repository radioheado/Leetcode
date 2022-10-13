class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int bulls = 0, cows = 0, n = secret.length();
        
        for (int i=0; i<n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) {
                bulls++;
            } else {
                if (map[s - '0'] < 0) {
                    cows++;
                } 
                if (map[g - '0'] > 0) {
                    cows++;
                }
                map[s - '0']++;
                map[g - '0']--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}