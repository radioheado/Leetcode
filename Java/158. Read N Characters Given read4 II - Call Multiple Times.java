/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    int copied = 0;
    char[] legacy = new char[4];
    
    public int read(char[] buf, int n) {
        int total = 0;
        int read = 4;
            
        while(copied>0){
            //System.out.print("legacy = ");
            //System.out.println(legacy);
            buf[total] = legacy[total];
            total++;
            copied--;
            //System.out.print("buf[total] = ");
            //System.out.println(buf[total]);
        }
        
        
        while(read>0 && total<n){
            char[] buf4 = new char[4];
            read = read4(buf4);
            
            for(int i=0; i<read; i++){
                buf[total] = buf4[i];
                //System.out.print("buf[total+i] = ");
                //System.out.println(buf[total+i]);
                total++;
            }
        }
        //System.out.println("total = " + total);
        
        for(int i=0; i<(total-n); i++){
            legacy[i] = buf[n+i];
            
            //System.out.print("buf[n+i] = ");
            //System.out.println(buf[n+i]);
        }
        copied = total-n;
        
        return Math.min(total, n);
    }
}