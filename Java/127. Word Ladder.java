class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> transform = new HashMap<>();
        int L = beginWord.length();
        
        wordList.forEach( word -> {
            for(int i=0; i<L; i++){
                String cur = word.substring(0, i) + '*' + word.substring(i+1, L);
                List<String> trans = transform.getOrDefault(cur, new ArrayList<>());
                trans.add(word);
                transform.put(cur, trans);
            }
        });
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while(!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String w = curr.getKey();
            int dis  = curr.getValue();
            for(int i=0; i<L; i++) {
                String trans = w.substring(0, i) + '*' + w.substring(i+1, L);
                for(String nei: transform.getOrDefault(trans, new ArrayList<>())) {
                    if(nei.equals(endWord)) {
                        return dis+1;
                    }
                    
                    if(!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(new Pair(nei, dis+1));
                    }
                }
            }
        }
        return 0;
    }
}