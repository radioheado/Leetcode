class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char t: tasks) {
            freqs[t - 'A']++;
        }
        
        Arrays.sort(freqs);
        int fmax = freqs[25];
        int idle = (fmax - 1) * n;
        
        for (int i=24; i>=0; i--) {
            idle -= Math.min(fmax - 1, freqs[i]);
        }
        idle = Math.max(0, idle);
        
        return idle + tasks.length;
    }
}