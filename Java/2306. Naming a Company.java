class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] suffix = new HashSet[26];
        
        for (int i = 0; i < 26; ++i) {
            suffix[i] = new HashSet<>();
        }

        for (String i: ideas) {
            suffix[i.charAt(0) - 'a'].add(i.substring(1));
        }

        long ans = 0;
        for (int i=0; i<25; ++i) {
            for (int j=i+1; j<26; ++j) {
                long same = 0;
                for (String a: suffix[i]) {
                    if (suffix[j].contains(a)) {
                        same++;
                    }
                }
                ans += 2 * (suffix[i].size() - same) * (suffix[j].size() - same);
            }
        }

        return ans;
    }
}