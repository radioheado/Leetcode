class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int weight = 0, available;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        for (int[] box: boxTypes) {
            available = Math.min(truckSize, box[0]);
            weight += box[1] * available;
            truckSize -= available;
            if (truckSize == 0)     break;
        }
        
        return weight;
    }
}