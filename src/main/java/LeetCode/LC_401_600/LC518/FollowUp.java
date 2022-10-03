package LeetCode.LC_401_600.LC518;

import java.util.*;

public class FollowUp {
    public static List<List<Integer>> coinCombinations(int amount, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(amount, coins, new LinkedList<>(), res, new HashSet<>());
        return res;
    }

    private static void dfs(int amount, int[] coins, LinkedList<Integer> list, List<List<Integer>> res, Set<String> visited) {
        if (amount < 0) return;
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        if (amount == 0 && !visited.contains(copy.toString())) {
            // System.out.println(list + " " + amount);
            res.add(copy);
            visited.add(copy.toString());
            return;
        }
        for (int coin : coins) {
            list.addLast(coin);
            dfs(amount - coin, coins, list, res, visited);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 5;
        System.out.println(coinCombinations(amount1, coins1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(coinCombinations(amount2, coins2));

        int[] coins3 = {10};
        int amount3 = 10;
        System.out.println(coinCombinations(amount3, coins3));

        int[] coins4 = {2, 3, 4};
        int amount4 = 9;
        System.out.println(coinCombinations(amount4, coins4));

        int[] coins5 = {4, 5, 6, 7};
        int amount5 = 22;
        System.out.println(coinCombinations(amount5, coins5));
    }
}
