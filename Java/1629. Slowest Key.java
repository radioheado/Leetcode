class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int time = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i-1] > time) {
                time = releaseTimes[i] - releaseTimes[i-1];
                ans = keysPressed.charAt(i);
            } else if (releaseTimes[i] - releaseTimes[i-1] == time) {
                ans = (char)Math.max((int)ans, (int)keysPressed.charAt(i));
            }
        }

        return ans;
    }
}