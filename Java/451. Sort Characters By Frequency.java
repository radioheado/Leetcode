class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int max = 0;
        
        for (char c: s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
            max = Math.max(max, chars.get(c));
        }
        
        List<List<Character>> buckets = new ArrayList<>();
        for (int i=0; i<=max; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Character c: chars.keySet()) {
            buckets.get(chars.get(c)).add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=buckets.size()-1; i >= 1; i--) {
            for (Character c: buckets.get(i)) {
                for (int j=0; j<i; j++) {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}