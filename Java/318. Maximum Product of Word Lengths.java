class Solution {
    public int maxProduct(String[] words) {
        int N = words.length;
        int[] masks = new int[N], lens = new int[N];
        int bitmask = 0, l = 0;
        
        for (int i=0; i<N; i++) {
            bitmask = 0;
            l = 0;
            for (char c: words[i].toCharArray()) {
                l++;
                bitmask |= 1 << bitNum(c);
            }
            masks[i] = bitmask;
            lens[i] = l;
        }
        
        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, lens[i] * lens[j]);
                }
            }
        }
        
        return ans;
    }
    
    private int bitNum(char c) {
        return (int)c - (int)'a';
    }
}