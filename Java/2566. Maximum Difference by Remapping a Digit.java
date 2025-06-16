class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        char first_none_nine = '9';

        for(char c: s.toCharArray()) {
            if (c != '9') {
                first_none_nine = c;
                break;
            }
        }

        s = s.replace(first_none_nine, '9');
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}