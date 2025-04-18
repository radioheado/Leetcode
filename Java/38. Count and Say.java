class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');

        for (int i = 1; i < n; i++) {
            int count = 1;
            char pre = sb.charAt(0);
            StringBuilder temp = new StringBuilder();

            for (char c: sb.substring(1).toCharArray()) {
                if (c == pre) {
                    count++;
                } else {
                    temp.append(Integer.toString(count));
                    temp.append(pre);
                    pre = c;
                    count = 1;
                }
            }

            temp.append(Integer.toString(count));
            temp.append(pre);
            sb = temp;
        }

        return sb.toString();
    }
}