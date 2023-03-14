class Solution {
    public int nthUglyNumber(int n) {
        LinkedList<Integer> nums = new LinkedList();
        nums.add(1);
        int i2 = 0, i3 = 0, i5 = 0, next_num;

        for (int i=1; i<n; i++) {
            next_num = Math.min(Math.min(nums.get(i2) * 2, nums.get(i3) * 3), nums.get(i5) * 5);
            
            if (nums.get(i2) * 2 == next_num) {
                i2++;
            }
            if (nums.get(i3) * 3 == next_num) {
                i3++;
            }
            if (nums.get(i5) * 5 == next_num) {
                i5++;
            }
            nums.add(next_num);
        }

        return nums.getLast();
    }
}