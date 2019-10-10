package LeetCode;

public class LeetCode1134 {
    public boolean isArmstrong(int N) {
        String ns = String.valueOf(N);
        int kthPower = ns.length();
        int digitPower = 0;
        for(char ch : ns.toCharArray()) {
            digitPower += (int)Math.pow(ch - '0', kthPower);
        }
        return N == digitPower;
    }
}
