class Solution {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> bits = new ArrayList<>();
        for (int i=0; i<14; i++) {
            bits.add(new ArrayList<>());
        }
        
        int count;
        for (int n: arr) {
            count = countOne(n);
            bits.get(count).add(n);
        }
        
        int[] ans = new int[arr.length];
        count = 0;
        for (List<Integer> b: bits) {
            Collections.sort(b);
            for (Integer n: b) {
                ans[count++] = n;
            }
        }
        
        return ans;
    }
    
    private int countOne(int num) {
        String bin = Integer.toBinaryString(num);
        int count = 0;
        for (char c: bin.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}