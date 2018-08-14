package LeetCode;

public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        for(int[] row:A) {
            for(int i = 0; i<(length+1)/2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[length-1-i] ^ 1;
                row[length-1-i] = temp;
            }
        }
        return A;
    }
}
