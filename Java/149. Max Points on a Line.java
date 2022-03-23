import java.math.BigInteger;
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        
        int ans = 0;
        for (int i=0; i<points.length; i++) {
            Map<String, Integer> lines = new HashMap<>();
            for (int j=i+1; j<points.length; j++) {
                String slope = getSlope(points[i], points[j]);
                lines.put(slope, lines.getOrDefault(slope, 1) + 1);
                ans = Math.max(ans, lines.get(slope));
            }
        }
        
        return ans;
        
    }
    
    private String getSlope(int[] p1, int[] p2) {
        int x = p1[0]-p2[0], y = p1[1]-p2[1];
        if (x == 0) {
            return "0,0";
        } else if (y == 0) {
            return new String (Integer.MAX_VALUE + "," + Integer.MAX_VALUE);
        } else if (x < 0) {
            x = -x;
            y = -y;
        }
        
        int gcd = BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
        return new String (x/gcd + "," + y/gcd);
    }
}