class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int l = plantTime.length;
        Flower[] flowers = new Flower[l];

        for (int i=0; i<l; i++) {
            flowers[i] = new Flower(plantTime[i], growTime[i]);
        }

        Arrays.sort(flowers, (a, b) -> a.grow == b.grow ? a.plant - b.plant : b.grow - a.grow);
        int ans = 0, cur = 0;

        for (Flower f: flowers) {
            cur += f.plant;
            ans = Math.max(ans, cur + f.grow);   
        }

        return ans;
    }

    class Flower {
        int plant, grow;

        public Flower (int p, int g) {
            plant = p;
            grow  = g;
        }
    }
}