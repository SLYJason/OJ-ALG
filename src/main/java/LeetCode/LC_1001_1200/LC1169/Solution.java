package LeetCode.LC_1001_1200.LC1169;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        if(transactions.length == 0) return new ArrayList();
        int len = transactions.length;
        String[] name = new String[len];
        int[] time = new int[len];
        int[] amount = new int[len];
        String[] city = new String[len];
        int idx = 0;
        // process the transactions first.
        for(String transaction : transactions) {
            String[] split = transaction.split(",");
            name[idx] = split[0];
            time[idx] = Integer.valueOf(split[1]);
            amount[idx] = Integer.valueOf(split[2]);
            city[idx] = split[3];
            idx++;
        }

        boolean[] add = new boolean[len]; // track any transaction should be marked as invalid.
        // compare each transaction with another transaction one by one.
        for(int i=0; i<len; i++) {
            if(amount[i] > 1000) {
                add[i] = true;
            }
            for(int j=i+1; j<len; j++) {
                if(name[i].equals(name[j])) {
                    if(Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                        add[i] = true;
                        add[j] = true;
                    }
                }
            }
        }
        // build final result.
        List<String> res = new ArrayList();
        for(int i=0; i<len; i++) {
            if(add[i]) res.add(transactions[i]);
        }
        return res;
    }
}
