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
    public int read(char[] buf, int n) {
        
        char[] buf4 = new char[4];
        int count = 0;
        int read = 4;
        
        while(read>0 && count<n){
            read = read4(buf4);
            
            for(int i=0; i<read; i++){
                if(count == n){
                    return count;
                }
                
                buf[count] = buf4[i];
                count++;
            }
        }
        
        return count;
        
        
    }
}