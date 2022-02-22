class Solution {
    public int[] findOriginalArray(int[] changed) {
        int N = changed.length;
        // special case
        if(N%2 == 1) {
            return new int[]{};
        }
        
        Map<Integer, Integer> nums = new HashMap<>();
        for(int c: changed) {
            nums.put(c, nums.getOrDefault(c, 0)+1);
        }
        
        List<Integer> order = new ArrayList<>(nums.keySet());
        Collections.sort(order);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int n: order) {
            if(n == 0) {
                // odd number of 0s
                if(nums.get(0)%2 == 1) {
                    return new int[]{};
                } else {
                    for(int i=0; i<nums.get(0)/2; i++) {
                        ans.add(0);
                    }
                }
            } else {
                if(nums.containsKey(n*2) && nums.get(n*2) > 0) {
                    int min = Math.min(nums.get(n), nums.get(n*2));
                    for(int i=0; i<min; i++) {
                        ans.add(n);
                    }
                    nums.put(n, nums.get(n)-min);
                    nums.put(n*2, nums.get(n*2)-min);
                }
            }
        }
        
        return ans.size() == N/2 ? ans.stream().mapToInt(i->i).toArray() : new int[]{};
    }
}