class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> chars = new HashMap();
        String str = "AEIOUaeiou";

        for (char c: str.toCharArray()) {
            chars.put(c, 0);
        }

        for (char c: s.toCharArray()) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char c: s.toCharArray()) {
            if (chars.containsKey(c)) {
                while (chars.get(str.charAt(i)) == 0) {
                    i++;
                }

                ans.append(str.charAt(i));
                chars.put(str.charAt(i), chars.get(str.charAt(i)) - 1);
                
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}