class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getDiff(nums1, nums2), getDiff(nums2, nums1));
    }

    private List<Integer> getDiff(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet();
        Set<Integer> n2 = new HashSet();

        for (int n: nums2) {
            n2.add(n);
        }
        for (int n: nums1) {
            if (!n2.contains(n)) {
                n1.add(n);
            }
        }

        return new ArrayList<>(n1);
    }
}