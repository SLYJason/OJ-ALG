package LeetCode.Array;

public class LeetCode1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for(int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return (sum - min - max)*1.0/(salary.length-2);
    }
}
