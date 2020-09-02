package LeetCode.String;

public class LeetCode157 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int numOfRead = 0; // each number of characters read from read4()
        int total = 0;  // total number of characters read
        do{
            numOfRead = read4(buf4);
            for(int i=total, j=0; j<numOfRead; i++, j++) {
                buf[i] = buf4[j];
            }
            total += numOfRead;
        }while(numOfRead > 0);
        return n > total ? total : n;
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf4);
     */
    public int read4(char[] buf4){
        return 0;
    }
}
