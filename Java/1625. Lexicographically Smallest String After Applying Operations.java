class Solution {
    Map<String, String> digits;
    public String findLexSmallestString(String s, int a, int b) {
        digits = new HashMap<>();
        for (int n = 0; n <= 9; n++) {
            digits.put(String.valueOf(n), String.valueOf((n + a) % 10));
        }

        Set<String> seen = new HashSet<>();
        dfs(s, seen, b);
        return seen.stream().min(String::compareTo).orElse("");
    }

    private String adds(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                sb.append(digits.get(String.valueOf(s.charAt(i))));
            }        
        }
        return sb.toString();
    }

    private String rotate(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }

    private void dfs(String s, Set<String> seen, int b) {
        if (seen.contains(s)) {
            return;
        }
        seen.add(s);
        dfs(adds(s), seen, b);
        dfs(rotate(s, b), seen, b);
    }
}