class Solution {
    public double average(int[] salary) {
        int total = 0, count = -2;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for (int n: salary) {
            total += n;
            count++;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return (double) (total-max-min) / count;
    }
}