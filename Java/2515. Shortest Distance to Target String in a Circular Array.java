class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int N = words.length;

        for (int i = 0; i < N; i++) {
            int l = (startIndex - i + N) % N;
            int r = (startIndex + i) % N;

            if (target.equals(words[l]) || target.equals(words[r])) {
                return i;
            }
        }

        return -1;
    }
}