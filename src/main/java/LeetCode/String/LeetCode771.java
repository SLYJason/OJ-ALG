package LeetCode.String;

public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char ch : S.toCharArray()) {
            if(J.contains(Character.toString(ch))) count++;
        }
        return count;
    }
}
