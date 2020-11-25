package Karat.Longest_Contiguous_History;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findContiguousHistory(String[] user1, String[] user2) {
        List<String> res = new ArrayList<>();
        int[][] dp = new int[user1.length+1][user2.length+1];
        int max_length = 0, end_index = 0;
        for(int i=1; i<user1.length+1; i++) {
            for(int j=1; j<user2.length+1; j++) {
                dp[i][j] = user1[i-1].equals(user2[j-1]) ? dp[i-1][j-1] + 1 : 0;
                if(dp[i][j] > max_length) {
                    max_length = dp[i][j];
                    end_index = i-1;
                }
            }
        }
        if(max_length == 0) return res;
        for(int i=end_index; i>end_index - max_length; i--) {
            res.add(0, user1[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        String[] user0 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user1 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};

        Solution s = new Solution();
        System.out.println("findContiguousHistory(user0, user1):");
        System.out.println(s.findContiguousHistory(user0, user1));

        System.out.println("findContiguousHistory(user1, user2):");
        System.out.println(s.findContiguousHistory(user1, user2));

        System.out.println("findContiguousHistory(user2, user0):");
        System.out.println(s.findContiguousHistory(user2, user0));

        System.out.println("findContiguousHistory(user5, user2):");
        System.out.println(s.findContiguousHistory(user5, user2));

        System.out.println("findContiguousHistory(user3, user4):");
        System.out.println(s.findContiguousHistory(user3, user4));

        System.out.println("findContiguousHistory(user4, user3):");
        System.out.println(s.findContiguousHistory(user4, user3));
    }
}
