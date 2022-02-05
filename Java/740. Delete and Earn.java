class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        int avoid = 0, using = 0, prev = -1;
        ArrayList<Integer> sorted = new ArrayList<>(count.keySet());
        Collections.sort(sorted);
        for(int n: sorted){
            int temp = Math.max(avoid, using);
            if(n-1 != prev){
                using = n*count.get(n) + temp;
            }else{
                using = n*count.get(n) + avoid;
            }
            avoid = temp;
            prev = n;
        }
        
        return Math.max(avoid, using);
    }
}