class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> chars = new HashMap<>();
        for (String w: words) {
            for (char c: w.toCharArray()) {
                chars.put(c, chars.getOrDefault(c, 0) + 1);
            }
        }

        int total = words.length;
        for (int count: chars.values()) {
            if (count % total > 0) {
                return false;
            }
        }

        return true;
    }
}