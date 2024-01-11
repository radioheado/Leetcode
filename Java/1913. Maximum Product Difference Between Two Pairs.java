class Solution {
    public int maxProductDifference(int[] nums) {
        int biggest = 0, secbig = 0;
        int smallest = 10001, secsmall = 10001;

        for (int n: nums) {
            if (n >= biggest) {
                secbig = biggest;
                biggest = n;
            } else if (n > secbig) {
                secbig = n;
            }

            if (n <= smallest) {
                secsmall = smallest;
                smallest = n;
            } else if (n < secsmall) {
                secsmall = n;
            }
        }

        return biggest * secbig - smallest * secsmall;
    }
}