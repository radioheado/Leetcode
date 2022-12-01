class Solution {
    public boolean halvesAreAlike(String s) {
        int l = 0, r = s.length() - 1, v1 = 0, v2 = 0;
        Set<Character> vowels = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            .collect(Collectors.toCollection(HashSet::new));
        
        while (l < r) {
            if (vowels.contains(s.charAt(l++))) {
                v1++;
            }
            if (vowels.contains(s.charAt(r--))) {
                v2++;
            }
        }
        
        return v1 == v2;
    }
}