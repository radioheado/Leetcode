class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int ans = 0, count = 0, last = 0;
        char prev = chars[0];
        
        for (char c: chars) {
            if (c == prev) {
                count++;
            } else {
                chars[last++] = prev;
                ans++;

                if (count > 1) {
                    String s = String.valueOf(count);
                    ans += s.length();

                    for (char d: s.toCharArray()) {
                        chars[last++] = d;
                    }
                }

                prev = c;
                count = 1;
            }
        }
        chars[last++] = prev;
        ans++;
        if (count > 1) {
            String s = String.valueOf(count);
            ans += s.length();

            for (char d: s.toCharArray()) {
                chars[last++] = d;
            }
        }

        return ans;

    }
}