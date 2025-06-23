class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        List<String> ans = new ArrayList<>();
        int i = 0, cur = 0;

        while (cur < len) {
            ans.add(s.substring(cur, Math.min(cur + k, len)));
            i++;
            cur += k;
        }

        String last = ans.get(ans.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            ans.set(ans.size() - 1, last);
        }

        return ans.toArray(new String[0]);
    }
}