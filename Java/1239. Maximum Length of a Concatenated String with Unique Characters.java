class Solution {
    private int ans = 0;
    
    public int maxLength(List<String> arr) {
        backtrack(arr, 0, 0, new HashSet<Character>());
        return ans;
    }
    
    private void backtrack(List<String> arr, int start, int length, Set<Character> seen) {
        ans = Math.max(ans, length);
        
        for (int i = start; i < arr.size(); i++) {
            Set<Character> chars = new HashSet();
            String sub = arr.get(i);
            boolean dup = true;

            for (char c: sub.toCharArray()) {
                if (chars.contains(c) || seen.contains(c)) {
                    dup = false;
                } 
                chars.add(c);
            }
            
            if (!dup) {
                backtrack(arr, i + 1, length, seen);
            } else {
                chars.addAll(seen);
                backtrack(arr, i + 1, length + sub.length(), chars);
            }
        }
        
    }
}