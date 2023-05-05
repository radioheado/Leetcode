class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0, l = 0, ans = 0;

        for (int r=0; r<s.length(); r++) {
            if (vowels.contains(s.charAt(r))) {
                count++;
            }
            
            if (r - l + 1 > k) {
                if (vowels.contains(s.charAt(l++))) {
                    count--;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}