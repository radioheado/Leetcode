class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int pivot = -1;
        for (int i=0; i<s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                if (pivot == -1) {
                    pivot = i;
                } else {
                    if (s1.charAt(pivot) != c2 || s2.charAt(pivot) != c1) {
                        return false;
                    }
                    return s1.substring(i+1).equals(s2.substring(i+1));
                }
            }
        }
        return pivot == -1 ? true : false;
    }
}