class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char prefix = word.charAt(0);
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prefix) {
                count++;
            } else {
                if (count > 0) {
                    sb.append(count);
                    sb.append(prefix);
                }
                prefix = c;
                count = 1;
                continue;
            }

            if (count == 9) {
                sb.append(count);
                sb.append(prefix);
                count = 0;
            }
        }

        if (count > 0) {
            sb.append(count);
            sb.append(prefix);
        }

        return sb.toString();
    }
}