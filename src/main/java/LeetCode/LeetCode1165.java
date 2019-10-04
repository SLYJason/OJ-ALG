package LeetCode;

public class LeetCode1165 {
    public int calculateTime(String keyboard, String word) {
        int time = 0;
        int currentIndex = 0;
        for(char c : word.toCharArray()) {
            int nextIndex = keyboard.indexOf(String.valueOf(c));
            time += Math.abs(currentIndex - nextIndex);
            currentIndex = nextIndex;
        }
        return time;
    }
}
