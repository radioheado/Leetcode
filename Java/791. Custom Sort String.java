class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> chars = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (char c: order.toCharArray()) {
            if (chars.containsKey(c)) {
                while (chars.getOrDefault(c, 0) > 0) {
                    sb.append(c);
                    chars.put(c, chars.get(c) - 1);
                }
            }
        }

        for (char c: chars.keySet()) {
            while (chars.getOrDefault(c, 0) > 0) {
                    sb.append(c);
                    chars.put(c, chars.get(c) - 1);
            }
        }

        return sb.toString();
    }
}