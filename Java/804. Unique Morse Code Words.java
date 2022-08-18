class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        
        Set<String> ans = new HashSet();
        
        for (String w: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: w.toCharArray()) {
                sb.append(codes[c - 'a']);
            }
            ans.add(sb.toString());
        }
        
        return ans.size();
    }
}