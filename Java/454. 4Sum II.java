class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> twoSum1 = twoSumCount(nums1, nums2);
        Map<Integer, Integer> twoSum2 = twoSumCount(nums3, nums4);
        
        int ans = 0;
        
        for(int n1: twoSum1.keySet()){
            if(twoSum2.containsKey(-n1)){
                ans += twoSum1.get(n1)*twoSum2.get(-n1);
            }
        }
        
        return ans;
        
    }
    
    private HashMap twoSumCount(int[] nums1, int[] nums2){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n: nums2){
            counts.put(n, counts.getOrDefault(n, 0)+1);
        }
        
        HashMap<Integer, Integer> twoSum = new HashMap<>();
        for(int n1: nums1){
            for(int n2: counts.keySet()){
                int sum = n1+n2;
                int c2 = counts.get(n2);
                twoSum.put(sum, twoSum.getOrDefault(sum, 0)+c2);
                
            }
        }
        
        return twoSum;
    }
}