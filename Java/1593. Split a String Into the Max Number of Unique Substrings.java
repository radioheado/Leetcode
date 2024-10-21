class Solution {
    public int maxUniqueSplit(String s) {
        int[] maxCount = new int[1];
        backtrack(s, 0, new HashSet<String>(), 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(String s, int l, Set<String> seen, int count, int[] maxCount) {
        if (count + (s.length() - l) <= maxCount[0]) {
            return;
        }

        if (l == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        for (int r = l + 1; r <= s.length(); r++) {
            String substring = s.substring(l, r);
            if (!seen.contains(substring)) {
                seen.add(substring);
                backtrack(s, r, seen, count + 1, maxCount);
                seen.remove(substring);
            }
        }
    } 
}