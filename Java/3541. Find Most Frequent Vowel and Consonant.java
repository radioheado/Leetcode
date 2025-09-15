class Solution {
    public int maxFreqSum(String s) {
        int vowel = 0, cons = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
            if ("aeiou".indexOf(c) != -1) {
                vowel = Math.max(vowel, count.get(c));
            } else {
                cons = Math.max(cons, count.get(c));
            }
        }

        return vowel + cons;
    }
}