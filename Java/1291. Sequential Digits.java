class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> nums = new ArrayList<>();
        String window = "123456789";
        int lows = Integer.toString(low).length();
        int highs = Integer.toString(high).length();
        
        for(int len = lows; len <= highs; len++){
            for(int start = 0; start < 10-len; start++){
                int num = Integer.parseInt(window.substring(start, start+len));
                if(num >= low && num <= high){
                    nums.add(num);
                }
            }
        }
        
        return nums;
    }
}