class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String a: arr) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for (String a: arr) {
            if (count.get(a) == 1) {
                k--;
                if (k == 0) {
                    return a;
                }
            }
        }

        return new String();
    }
}