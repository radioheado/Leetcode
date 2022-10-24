class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        
        for (int i=1; i<6; i+=2) {
            sb.append(find(color.substring(i, i+2)));
        }
        return sb.toString();
    }
    
    private String find(String color) {
        int num = Integer.parseInt(color, 16);
        int r = Math.round((float) num/17);
        return Integer.toHexString(r).repeat(2);
    }
    
}