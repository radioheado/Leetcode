class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Set<Integer> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordDict);
        int L = s.length();
        
        while (!q.isEmpty()) {
            int start = q.poll();
            if (visited.contains(start)) {
                 continue;
            }
            
            visited.add(start);
            for (int end=start; end<L; end++) {
                if (words.contains(s.substring(start, end+1))) {
                    if (end == L-1) {
                        return true;
                    }
                    q.add(end+1);
                }
            }
        }
        
        return false;
    }
}