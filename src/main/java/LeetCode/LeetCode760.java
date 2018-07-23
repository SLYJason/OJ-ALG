package LeetCode;

import java.util.Map;
import java.util.HashMap;

public class LeetCode760 {
    public int[] anagramMappings(int[] A, int[] B) {
        int size = A.length;
        int[] P = new int[size];
        Map map = new HashMap<Integer, Integer>();
        for(int i=0; i<size; i++) {
            map.put(B[i], i);
        }
        for(int i=0; i<size; i++){
            P[i] = (int)map.get(A[i]);
        }
        return P;
    }
}
