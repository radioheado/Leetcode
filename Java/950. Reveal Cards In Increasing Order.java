class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int d = 0, a = 0, N = deck.length;
        int[] ans = new int[N];
        boolean skip = false;

        while (d < N) {
            if (ans[a] == 0) {
                if (!skip) {
                    ans[a] = deck[d++];
                }
                skip = !skip;
            }
            a = (a + 1) % N;
        }
        
        return ans;
    }
}