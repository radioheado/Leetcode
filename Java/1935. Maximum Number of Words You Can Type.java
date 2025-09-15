class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        Set<Character> broken = new HashSet<>();
        for (char c: brokenLetters.toCharArray()) {
            broken.add(c);
        }

        for (String word: text.split(" ")) {
            boolean flag = true;
            for (char c: word.toCharArray()) {
                if (broken.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }

        return ans;
    }
}