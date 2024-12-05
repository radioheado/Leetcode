class Solution {
    public boolean canChange(String start, String target) {
        int p1 = 0, p2 = 0, size = start.length();

        while (p1 < size || p2 < size) {
            while (p1 < size && start.charAt(p1) == '_') {
                p1++;
            }

            while (p2 < size && target.charAt(p2) == '_') {
                p2++;
            }

            if (p1 == size || p2 == size) {
                return p1 == size && p2 == size;
            }

            if (start.charAt(p1) != target.charAt(p2)) {
                return false;
            }

            if (p1 > p2 && start.charAt(p1) == 'R' || p1 < p2 && start.charAt(p1) == 'L') {
                return false;
            }

            p1++;
            p2++;
        }
        return true;
    }
}