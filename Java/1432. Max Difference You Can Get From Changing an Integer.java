class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String t = s;
        char none_nine = '9';
        for (char c: s.toCharArray()) {
            if (c != '9') {
                none_nine = c;
                break;
            }
        }

        s = s.replace(none_nine, '9');
        if (t.charAt(0) != '1' || t.length() == 1) {
            t = t.replace(t.charAt(0), '1');
        } else {
            int p = 1;
            while (p < t.length() && (t.charAt(p) == '0' || t.charAt(p) == t.charAt(0))) {
                p++;
            }
            if (p < t.length()) {
                t = t.replace(t.charAt(p), '0');
            }
        }
        
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}