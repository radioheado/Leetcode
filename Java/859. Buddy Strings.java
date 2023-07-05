class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }

        int idx = -1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (idx == -1) {
                    idx = i;
                } else {
                    if (!flag || s.charAt(idx) != goal.charAt(i) || s.charAt(i) != goal.charAt(idx)) {
                        return false;
                    } 
                    flag = false;
                }
            }
        }

        return !flag;
    }
}