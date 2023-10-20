class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        int count1 = 0, count2 = 0, cand1 = (int)Math.pow(10, 9) + 1, cand2 = (int)Math.pow(10, 9) + 1;
        for (int n: nums) {
            if (cand1 == n) {
                count1++;
            } else if (cand2 == n) {
                count2++;
            } else if (count1 == 0) {
                cand1 = n;
                count1++;
            } else if (count2 == 0) {
                cand2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList();
        count1 = 0;
        count2 = 0;
        
        for (int n: nums) {
            if (cand1 != (int)Math.pow(10, 9) + 1 && n == cand1) {
                count1++;
            }
            if (cand2 != (int)Math.pow(10, 9) + 1 && n == cand2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            ans.add(cand1);
        }
        if (count2 > nums.length / 3) {
            ans.add(cand2);
        }
        return ans;
    }
}