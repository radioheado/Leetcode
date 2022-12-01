class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        for (int n: arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        Set<Integer> occur = new HashSet();
        for (int v: count.values()) {
            if (occur.contains(v)) {
                return false;
            }
            occur.add(v);
        }
        
        return true;
    }
}