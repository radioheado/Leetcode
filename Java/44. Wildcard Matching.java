class Solution {
    public boolean isMatch(String s, String p) {
        // s index, p index
        int si = 0, pi = 0;

        // s length, p length
        int sl = s.length(), pl = p.length();

        // star index, temp index
        int star = -1, temp = -1;

        while (si < sl) {
            if (pi < pl && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < pl && p.charAt(pi) == '*') {
                star = pi;
                temp = si;
                pi++;
            } else if (star == -1) {
                return false;
            } else {
                pi = star + 1;
                si = temp + 1;
                temp = si;
            }
        }

        for (int i = pi; i < pl; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }
}