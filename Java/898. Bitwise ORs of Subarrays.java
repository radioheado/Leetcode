class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> glob = new HashSet<>();

        for (int n: arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(n);
            for (int p: prev) {
                curr.add(n | p);
            }
            glob.addAll(curr);
            prev = curr;
        }
        
        return glob.size();
    }
}