class Solution {
    private int count (int n) {
        return (n * (n+1)) / 2;
    }
    public int candy(int[] ratings) {
        int up = 0, down = 0, olds = 0, candies = 0, news;
        for (int i=1; i<ratings.length; i++) {
            news = (ratings[i-1] < ratings[i]) ? 1 : (ratings[i-1] > ratings[i]) ? -1 : 0;
            
            if ((olds > 0 && news == 0) || (olds < 0 && news >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            
            if (news > 0)   up++;
            else if (news < 0)  down++;
            else   candies++;
            
            olds = news;
        }
        
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}