class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = -1;
        long totalDamage = 0;
        for (int d: damage) {
            maxDamage = Math.max(maxDamage, d);
            totalDamage += d;
        }

        return totalDamage - Math.min(maxDamage, armor) + 1;
    }
}